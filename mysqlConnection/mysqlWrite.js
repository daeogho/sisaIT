// express 모듈을 이용하면 전송방식에 따라 get(), post()함수를 바로 접속할 수 있다.
// >npm install express;

var http = require('http');
// http.createServer(function(req, res{});

// express를 이용한 서버생성
var express = require('express');
var app = express();
var server = http.createServer(app);

// DB(mysql 환경설정)
// 모듈 추가 설치
// >npm install mysql2
var mysql = require('mysql2');

// DB연결
var connection = mysql.createConnection({
        host: '127.0.0.1',
        port: 3306,
        user: 'root',
        password: 'tiger1234',
        database: 'react_node_db'

});
connection.connect();

// post전송방식의 데이터를 request할수 있는 모듈 설정하기
var bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({ extended: true }));

// get방식 접속시 호출됨.
//    매핑주소
app.get("/memberList", function (req, res) {
        console.log("회원목록");//     ` : 그레이브
        var sql = `select m_no, name, tel, email, gender, birthdate, writedate 
                        from member order by m_no desc`;

        //select는 선택한 레코드를 json에 담고, json을 배열에 담아 반환한다.
        connection.execute(sql, function (error, results) {
                console.log(results);
                res.json({ records: results });
        });
});

app.post("/memberWrite", function (req, res) {
        // request에서 데이터 가져오기
        var name = req.body.name;
        var tel = req.body.tel;
        var email = req.body.email;
        var gender = req.body.gender;
        var birthdate = req.body.birthdate;

        var sql = "insert into member(name, tel, email, gender, birthdate) values(?,?,?,?,?)";
        //               쿼리문, ?들어갈 값                           콜백함수
        connection.execute(sql, [name, tel, email, gender, birthdate], function (error, result) {
                console.log(error);
                console.log(result);
                if (error || result.affectedRows == 0) { //등록실패 : 0
                        res.json({ result: 0 });
                } else {// 등록성공 : 1
                        res.json({ result: 1 });
                }

        });

        console.log(name, tel, email, gender, birthdate);
        console.log("회원등록");
});

// 회원수정
app.post("/memberEdit", function (req, res) {
        var m_no = req.body.m_no;
        var tel = req.body.tel;
        var email = req.body.email;

        var sql = "update member set tel = ?, email = ? where m_no=?"

        connection.execute(sql, [tel, email, m_no], function (error, results) {
                console.log(error, results);
                if (error || results.affectedRows == 0) {
                        res.json({ status: 0 });
                } else {
                        res.json({ status: 1 });
                }
        });
});

// 회원선택
app.get('/memberView', function (req, res) {
        var param = req.url.substring(req.url.indexOf("?") + 1); //memberView?m_no=7
        var params = new URLSearchParams(param);
        var m_no = params.get("m_no");

        var sql = `select m_no, name, tel, email, gender, birthdate,
                date_format(writedate,'%m~%d %H:%i') writedate from member
                where m_no=?`;          // [{}], []
        connection.execute(sql, [m_no], function (error, results) {
                res.json({ records: results[0] });
        });
});

//회원삭제
app.get('/memberDel', function (req, res) {
        var param = req.url.substring(req.url.indexOf("?") + 1);
        var params = new URLSearchParams(param);
        var m_no = params.get("m_no");

        var sql = `delete from member where m_no=?`;
        connection.execute(sql, [m_no], function (error, results) {
                console.log(error, results);
                if (error || results.affectedRows == 0) {
                        res.json({ status: 0 });
                } else {
                        res.json({ status: 1 })
                };
        });
});
// 회원수
app.get('/membernum', function (req, res) {
        var m_no = req.body.m_no;

        var sql = `select count(m_no) count,
                date_format(max(birthdate), '%Y-%m-%d')first_birth,
                date_format(min(birthdate), '%Y-%m-%d')last_birth from member`;

        connection.execute(sql, function (error, results) {
                console.log(results);
                res.json({ result: results[0] });
        });
});

/************************************************************ */

server.listen(12015, function () {
        console.log("mysql connection server start.....");
});