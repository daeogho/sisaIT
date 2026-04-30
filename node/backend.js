var express = require('express')
const multer = require('multer');
var app = express()

var cors = require('cors')
app.use(cors())
app.use(express.json())
// =========Session 사용하기
var session = require('express-session')
// ==================== DB설정 =========================
var mysql2 = require('mysql2')

var connection = mysql2.createConnection({
        host: '192.168.4.51',
        port: 3306,
        user: 'miniproject1',
        password: 'mini1',
        database: 'homelog'
});
connection.connect();


//로그인
app.post('/login', function (request, response) {
        var userid = request.body.userid
        var userpwd = request.body.userpwd

        // 아이디와 비밀번호가 일치하면 아이디와 이름을 선택한다.
        var query = `select userId, username, managerCheck from user_db
                     where userId=? and userpwd=?`
        connection.execute(query, [userid, userpwd], function (e, result) {
                console.log(result)

                if (!e && result.length > 0) {//로그인 성공
                        //session에 로그인정보(아이디와 이름)
                        //express-session 모듈추가 > npm install express-session
                        session.user = {
                                userid: result[0].userId,
                                username: result[0].username,
                                authorized: true
                        }
                        console.log('세션에 저장된 로그인 정보==>', session.user)
                        // react에게
                        // 아이디와 이름을 보내준다.
                        response.json({
                                user: session.user,
                                logStatus: 'Y'
                        })

                } else { // 로그인 실패
                        // react에게 실패정보 보내준다. 
                        response.json({
                                logStatus: 'N'
                        })
                }

        })
})
//로그아웃
app.get('/logout', function (request, response) {
        console.log(session.user)
        // session에 보관된 로그인 정보를 지운다.
        session.user = null;
        response.json({ logout: 'yes' })
})
//마이페이지 회원정보
app.get('/member/myPage', function (request, response) {
        var sql = 'select username, userId from user_db where userId=?';
        connection.execute(sql, [session.user.userid], function (error, result) {
                console.log("회원정보선택==>", result)
                response.json({ record: result[0] })
        })
})
//작성글
app.get('/member/writeboard', function (request, response) {
        var sql = `select no, subject, tag, context, userId, hit, date_format(writedate, '%m-%d %H-%i') writedate 
                        from homelog_db where userid=? `
        connection.execute(sql, [session.user.userid], function (error, result) {

                console.log("작성글==>", result)
                response.json({ record: result })
        })

})
//내가 좋아요한 글리스트
app.get('/member/likelist', function (request, response) {
        var sql = `SELECT h.no,h.subject,h.context,h.hit,DATE_FORMAT(h.writedate, '%Y-%m-%d') AS writedate FROM like_db l
                           JOIN homelog_db h ON l.no = h.no WHERE l.userid = ? ORDER BY l.writedate DESC `
        connection.execute(sql, [session.user.userid], function (error, result) {

                console.log("작성글==>", result)
                response.json({ record: result })
        })

})
//내가 쓴 댓글
app.get('/member/mycoment', function (request, response) {
        var sql = `SELECT h.no,h.subject,c.context,h.hit,DATE_FORMAT(c.writedate, '%Y-%m-%d') AS writedate FROM coment_db c
                   JOIN homelog_db h ON c.no = h.no WHERE c.userid = ? ORDER BY c.writedate DESC `
        connection.execute(sql, [session.user.userid], function (error, result) {

                console.log("내가쓴 댓글==>", result)
                response.json({ record: result })
        })

})
//회원정보폼
app.get('/memberEdit', function (request, response) {
        var sql = 'select userId,username, tel, email from user_db where userId=?';
        connection.execute(sql, [session.user.userid], function (error, result) {
                console.log("회원정보선택==>", result)
                response.json({ record: result[0] })
        })
})
//회원정보수정(DB업데이트)
app.post('/memberEditOk', function (request, response) {
        var sql = 'update user_db set username=?, tel=?, email=? where userId=? and userpwd=?';
        connection.execute(sql, [request.body.username, request.body.tel, request.body.email, request.body.userid, request.body.userpwd], function (error, result) {
                console.log(error, result)
                if (!error && result.affectedRows > 0) { // 수정됨
                        response.json({ result: 'OK' })
                } else { // 수정실패
                        response.json({ result: 'NO' })
                }
        })
})
// ---------------------------------김대호---------------------------------------------------
// 회원가입
app.post('/member', function (request, response) {
        // request.body.userid, request.body.userpwd.....
        var userid = request.body.userid;
        var userpwd = request.body.userpwd;
        var username = request.body.username;
        var tel = request.body.tel;
        var email = request.body.email; 

        var query = `insert into
                     user_db(userid, userpwd, username, tel, email, writedate, managerCheck) 
                     values(?,?,?,?,?,now(),2)`
        //           쿼리문 ->            데이터 ->              콜백함수(에러정보, 결과정보,)
        connection.execute(query, [userid, userpwd, username, tel, email], function (error, result) {

                if (error) {
                        console.log('회원가입 insert에러:', error);
                        return response.status(500).json({ result: 'fail' });
                }

                if (result.affectedRows == 1) {
                        response.json({ result: 'success' })
                } else {
                        response.json({ result: 'fail' })
                }
        })
})

// 집들이 게시글 목록
app.get('/member/sharing', function (request, response) {
        var tag = request.query.tag;
        let sql = `select a.no, a.userid, subject, tag, context, hit,date_format(a.writedate, '%m-%d %H-%i') writedate, 
                b.no likenum from homelog_db a left outer join like_db b on a.no=b.no  and b.userid=?`;
        
        if(tag==null || tag==''){ 
                sql += ` order by a.no desc`
                connection.execute(sql, [session.user.userid], (error, results) => {   
                        console.log(results)           
                        response.json({records:results});
                 })
        }else{
                sql += ` where tag like ? order by a.no desc`
                connection.execute(sql, [session.user.userid,`%${tag}%`], (error, results) => {   
                        console.log(results)           
                        response.json({records:results});                 
                })
        }
})
// 집들이 게시글 등록
app.post('/board/write', function (request, response) {

        // if (!request.session.user){
        //         return response.status(401).json({result : 'no-login'})
        // }
        var userid = session.user.userid;
        var tag = request.body.tag;
        var subject = request.body.subject;
        var context = request.body.context;

        console.log(tag, subject, context)

        var sql = `insert into homelog_db(userid, tag, subject, context, hit)
                   values(?,?,?,?,?)`;

        connection.execute(sql, [userid, tag, subject, context, 0], (error, result) => {
                console.log(result)

                if (!error && result.affectedRows == 1) { //글등록
                        response.json({ result: 'success' })

                } else {//글등록실패
                        response.json({ result: 'fail' })
                        console.log(error)
                }
        })
})
// 이미지 업로드 처리
const upload = multer({
        storage: multer.diskStorage({
                destination: 'uploads/',
                filename: (req, file, cb) => {
                        cb(null, Date.now() + '-' + file.originalname);
                },
        }),
});

app.post('/upload', upload.single('image'), (req, res) => {
        res.json({
                url: `http://192.168.4.86:9988/uploads/${req.file.filename}`,
        });
});

app.use('/uploads', express.static('uploads'));

// 집들이 게시글 보기
app.post('/member/boardview', function (request, response) {
        var board_no = request.body.board_no

        //조회수 증가
        var hitsql = 'update homelog_db set hit = hit + 1 where no = ?'
        connection.execute(hitsql, [board_no], (error, result) => {
                //게시글 조회
                var selectsql = `select no, subject, context, userid, hit, 
          date_format(writedate, '%Y-%m-%d %H:%i') writedate from homelog_db where no=?`
                connection.execute(selectsql, [board_no], function (error, result) {
                        var sql ='select count(likeno) cnt from like_db where no=? and userid=? '
                        connection.execute(sql, [board_no, session.user.userid], function (error, likeCnt) {

                           response.json(
                                { 
                                        record: result[0],
                                        likecheck : likeCnt[0].cnt
                                }
                           )
                        })                      
                })
        })
})
// 게시글 삭제
app.post('/board/del', function (request, response) {
        var board_no = request.body.board_no
        var query = 'delete from homelog_db where no =?'
        connection.execute(query, [board_no], (e, r) => {
                if (!e && r.affectedRows > 0) {
                        response.json({ result: 'ok' })
                } else {
                        response.json({ result: 'no' })
                }
        })
})
// 집들이 게시글 조회
app.post('/board/editForm', function (req, res) {
        const board_no = req.body.board_no

        const sql = 'select no, tag, subject, context from homelog_db where no=?'
        connection.execute(sql, [board_no], (e, r) => {
                res.json({ record: r[0] })
        })
})
//좋아요 처리
app.post('/member/like', function (request, response) {
        var board_no = request.body.board_no;
        var sql ='select count(likeno) cnt from like_db where no=? and userid=? '
        connection.execute(sql, [board_no, session.user.userid], function (error, result) {
                console.log(result)
                if(!error){
                        var resultcount = result[0].cnt;
                        if(resultcount==0){ // 좋아요가 안눌러진 상태
                                var insertsql = 'insert into like_db(no, userid) values(?,?)'
                                connection.execute(insertsql, [board_no, session.user.userid], function (error, result) {
                                        if(!error && result.affectedRows>0){
                                                response.json({likecheck:'like'})
                                        }else{
                                                response.json({likecheck:'no'})
                                        }
                                })
                        }else{
                                var deletesql = 'delete from like_db where no=? and userid=?'
                                connection.execute(deletesql, [board_no, session.user.userid], function (error, result) {
                                        if(!error && result.affectedRows>0){
                                                response.json({likecheck:'unlike'})
                                        }else{
                                                response.json({likecheck:'no'})
                                        }
                                })
                        }  
                }else{
                        console.log(error)
                }
        })
})       

//집들이 게시글 수정하기
app.post('/board/edit', function (request, response) {
        var no = request.body.no
        var subject = request.body.subject
        var context = request.body.context
        var tag = request.body.tag
        console.log(no, tag, subject, context)

        var sql = 'update homelog_db set tag=?, subject=?, context=? where no=?'
        connection.execute(sql, [tag, subject, context, no], function (e, r) {
                if (!e && r.affectedRows > 0) {
                        response.json({ result: 'success' })
                } else {
                        response.json({ result: 'fail' })
                }
        })

})
// 댓글 등록
app.post('/comment/write', (req, res) => {
        if (!session.user) {
                return res.json({ result: 'no-login' })
        }

        const userid = session.user.userid
        const { board_no, context } = req.body
        console.log(board_no, context)
        const sql = `insert into coment_db (userid, context, board, no)
                     values(?, ?, ?, ?) `

        connection.execute(sql, [userid, context, board_no, board_no], (e, r) => {
                console.log(e)
                if (!e && r.affectedRows > 0) {
                        res.json({ result: 'success' })
                } else {
                        res.json({ result: 'fail' })
                }
        })
})
// 댓글 목록
app.post('/comment/list', (req, res) => {
        const { board_no } = req.body
        const sql = ` SELECT comentno, userid, context, DATE_FORMAT(writedate, '%Y-%m-%d %H:%i') AS writedate
                      FROM coment_db WHERE no = ? ORDER BY comentno DESC
    `

        connection.execute(sql, [board_no], (e, r) => {
                if (!e) {
                        res.json({ records: r })
                } else {
                        console.log(e)
                        res.json({ records: [] })
                }
        })
})


// 댓글 삭제
app.post('/comment/delete', (req, res) => {
        const { comentno, userid } = req.body
        console.log(comentno, userid)
        // 로그인 체크
        if (!userid) {
                return res.json({ result: 'no-login' })
        }

        const sql = `delete from coment_db where comentno = ? and userid = ?`

        connection.execute(sql, [comentno, userid], (err, result) => {
                if (err) {
                        console.log(err)
                        return res.json({ result: 'fail' })
                }
                if (result.affectedRows === 0) {
                        return res.json({ result: 'no-auth' })
                }
                res.json({ result: 'success' })
        })
})

//------------------------------------------ 가영 -----------------------------------------
// const mysql = require('mysql2/promise');
// // var session = require('express-session');

// app.use(cors({
//         origin: 'http://localhost:5173',
// //         credentials: true,
// //         methods: ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'],
// //         allowedHeaders: ['Content-Type', 'Authorization']
// // }));


// // app.use(session({
// //         secret: 'mini1',
// //         resave: false,
// //         saveUninitialized: true
// // }));

// const homelog = mysql2.createPool({
//         host: '192.168.4.86',   
//         user: 'miniproject1',  
//         password: 'mini1',  
//         database: 'homelog', 
// });


// qna 게시글 등록
app.post('/interior/write', function (request, response) {

        var userid = session.user.userid;
        var subject = request.body.subject;
        var context = request.body.context;

        console.log(subject, context)

        var sql = `insert into tip_db(userid,subject, context, hit)
                   values(?,?,?,0)`;

        connection.execute(sql, [userid, subject, context], (error, result) => {
                if (!error && result.affectedRows == 1) { //글등록
                        response.json({ result: 'success' })

                } else {//글등록실패
                        response.json({ result: 'fail' })
                        console.log(error)
                }
        })
})

app.post('/ask/write', function (request, response) {

        // if (!request.session.user){
        //         return response.status(401).json({result : 'no-login'})
        // }
        var userid = session.user.userid;
        var subject = request.body.subject;
        var context = request.body.context;

        console.log(subject, context)

        var sql = `insert into userqna_db(userid,subject, context, hit)
                   values(?,?,?,0)`;

        connection.execute(sql, [userid, subject, context], (error, result) => {
                console.log(result)

                if (!error && result.affectedRows == 1) { //글등록
                        response.json({ result: 'success' })

                } else {//글등록실패
                        response.json({ result: 'fail' })
                        console.log(error)
                }
        })
})
app.post('/as/write', function (request, response) {

        // if (!request.session.user){
        //         return response.status(401).json({result : 'no-login'})
        // }
        var userid = session.user.userid;
        var subject = request.body.subject;
        var context = request.body.context;

        console.log(subject, context)

        var sql = `insert into as_db(userid,subject, context)
                   values(?,?,?)`;

        connection.execute(sql, [userid, subject, context], (error, result) => {
                console.log(result)

                if (!error && result.affectedRows == 1) { //글등록
                        response.json({ result: 'success' })

                } else {//글등록실패
                        response.json({ result: 'fail' })
                        console.log(error)
                }
        })
})
// 목차 불러오기
app.get('/interior/list', async (req, res) => {
        try {
                const sql = `SELECT no, subject, context FROM tip_db ORDER BY no DESC`;
                connection.execute(sql, [], function (error, rows) {
                        if (error) {
                                console.error('DB ERROR:', error);
                                return res.status(500).json({ error: 'DB error' });
                        }
                        res.json({ record: rows });
                });
        } catch (err) {
                console.error('DB ERROR:', err);
                res.status(500).json({ error: 'DB error' });
        }
});

// 목차 불러오기 (TIP 전용)
app.get('/ask/list', async (req, res) => {
        try {
                const sql = `SELECT no, subject, context FROM userqna_db ORDER BY no DESC`;
                connection.execute(sql, [], function (error, rows) {
                        if (error) {
                                console.error('DB ERROR:', error);
                                return res.status(500).json({ error: 'DB error' });
                        }
                        res.json({ record: rows });
                });
        } catch (err) {
                console.error('DB ERROR:', err);
                res.status(500).json({ error: 'DB error' });
        }
});

app.get('/as/ask', async (req, res) => {
        try {
                const sql = `SELECT no, subject, context FROM as_db ORDER BY no DESC`;
                connection.execute(sql, [], function (error, rows) {
                        if (error) {
                                console.error('DB ERROR:', error);
                                return res.status(500).json({ error: 'DB error' });
                        }
                        res.json({ record: rows });
                });
        } catch (err) {
                console.error('DB ERROR:', err);
                res.status(500).json({ error: 'DB error' });
        }
});

//게시글 삭제
app.post('/interior/del', function (request, response) {
        var no = request.body.no;
        console.log(no)
        var query = `DELETE FROM tip_db WHERE no = ?`;
        connection.execute(query, [no], function (e, result) {
                console.log(e, result)
                if (result.affectedRows > 0) {
                        response.json({ result: 'ok' });
                } else {
                        response.json({ result: 'no' });
                }
        });
});
app.post('/ask/del', async function (request, response) {

        var no = request.body.no;
        console.log(no)
        var query = `DELETE FROM userqna_db WHERE no = ?`;
        connection.execute(query, [no], function (e, result) {
                console.log(e, result)
                if (result.affectedRows > 0) {
                        response.json({ result: 'ok' });
                } else {
                        response.json({ result: 'no' });
                }
        });

});

app.post('/as/del', async function (request, response) {
        var no = request.body.no;
        console.log(no)
        var query = `DELETE FROM as_db WHERE no = ?`;
        connection.execute(query, [no], function (e, result) {
                console.log(e, result)
                if (result.affectedRows > 0) {
                        response.json({ result: 'ok' });
                } else {
                        response.json({ result: 'no' });
                }
        });
});
// tip게시판 게시글 조회
app.post('/interior/editForm', function (req, res) {
        const no = req.body.no

        const sql = 'select no, subject, context from tip_db where no=?'
        connection.execute(sql, [no], (e, r) => {
                res.json({ record: r[0] })
        })
})

// 게시글 수정
app.post('/interior/editOk', function (request, response) {
        var no = request.body.no
        var subject = request.body.subject
        var context = request.body.context
        console.log(no, subject, context)

        var sql = 'UPDATE tip_db SET subject = ?, context = ? WHERE no = ?'
        connection.execute(sql, [subject, context, no], function (e, r) {
                if (!e && r.affectedRows > 0) {
                        response.json({ result: 'success' })
                } else {
                        response.json({ result: 'fail' })
                }
        })

})
app.post('/ask/editOk', function (request, response) {
        var no = request.body.no
        var subject = request.body.subject
        var context = request.body.context
        console.log(no, subject, context)

        var sql = 'UPDATE userqna_db SET subject = ?, context = ? WHERE no = ?'
        connection.execute(sql, [subject, context, no], function (e, r) {
                if (!e && r.affectedRows > 0) {
                        response.json({ result: 'success' })
                } else {
                        response.json({ result: 'fail' })
                }
        })

})
app.post('/as/editOk', function (request, response) {
        var no = request.body.no
        var subject = request.body.subject
        var context = request.body.context
        console.log(no, subject, context)

        var sql = 'UPDATE as_db SET subject = ?, context = ? WHERE no = ?'
        connection.execute(sql, [subject, context, no], function (e, r) {
                if (!e && r.affectedRows > 0) {
                        response.json({ result: 'success' })
                } else {
                        response.json({ result: 'fail' })
                }
        })

})


app.listen(9988, function () {
        console.log('react가 사용할 node서버 실행됨...');
})