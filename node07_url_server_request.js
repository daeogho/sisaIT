var http = require('http');

var server = http.createServer(function(request, response){
        console.log(request.url);
        var url = request.url;
        response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
        if(url == "/"){// 홈페이지에 접속시
                response.end("<h1>홈페이지</h1>");
        }else if(url.indexOf("/board/list") == 0){ // 게시판목록
                response.end("<h1>게시판 목록 페이지</h1>");
        }else if(url.indexOf("/member/login") == 0){ //로그인
                response.write("<h1>로그인 폼</h1>");
                response.end("아이디와 비밀번호 입력하는 폼 작성하는 곳");
        }else if(url.indexOf("/notice/view") == 0){// 공지사항 글내용보기
                response.end("<h1>공지사항 글내용보기 페이지</h1>");
        }
});

server.listen(12006, function(){
        console.log("server start...... http://127.0.0.1:12006/");
        console.log("server start...... http://127.0.0.1:12006/board/list?page=2&word='홍길동'&key=subject"); // 게시판 목록
        console.log("server start...... http://127.0.0.1:12006/board/write");// 게시판 글쓰기
        console.log("server start...... http://127.0.0.1:12006/board/edit");// 게시판 수정
        console.log("server start...... http://127.0.0.1:12006/member/login");// 회원로그인
        console.log("server start...... http://127.0.0.1:12006/member/form");// 회원가입폼
        console.log("server start...... http://127.0.0.1:12006/notice/list");// 공지사항목록
        console.log("server start...... http://127.0.0.1:12006/notice/view?no=15");// 공지사항 글내용보기
        console.log("server start...... http://127.0.0.1:12006/notice/view");


});