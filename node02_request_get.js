var http = require('http');

var server = http.createServer(function(request, response){
        // 전송된 데이터는 request내의 url변수가 가지고 있다. 쿼리데이터라고 한다.
        // ?name=%ED%99%8D%EA%B8%B8%EB%8F%99&tel=010-1234-5678&age=30
        console.log("url=" + request.url);
        
        var queryData= request.url;
        // ?이전데이터 삭제
        // name=홍길동&tel=010-1234-5678&age=30
        var query = queryData.substring(queryData.indexOf("?")+1); // substring(idx);
        console.log('query', query);
        // URLSearchParams를 이용하여 문자열로 되어 있는 데이터를 객체로 만들기
        var params = new URLSearchParams(query);
        console.log('params', params);

        var name = params.get("name"); //홍길동
        var tel = params.get("tel"); // 010-1234-5678
        var age = params.get("age"); // 30

        // 서버에서 클라이언트가 보낸정보를 받아 다시 클라이언트에 보내기
        response.writeHead(200,{'Content-Type' : 'text/html; charset=UTF-8'});
        response.write("<a href='http://127.0.0.1:12001/?name=이순신&tel=010-9999-8888&age=40'>서버에 접속하여 데이터 보내기<br></a>")
        response.write("<button onclock='location.href=\"http://127.0.0.1:12001/?name=세종대왕&tel=010-1111-2222&age=50\"'>자바스크립트로 전송하기");
        response.write("<hr/>");
        response.write("<h1 style='color:blue'>서버가 받은 값</h1>");
        response.write("이름 : "+name+"</br>");
        response.write("연락처 : "+tel+"<br/>");
        response.write("나이 : " +age);
        response.write("<hr/>");

        // post 방식 전송폼 만들기
        response.write("<h1>post방식 전송폼</h1>");
        response.write("<form method='post' action='http://127.0.0.1:12002'>");
        response.write("번호 : <input type='text' name='num'/><br/>");
        response.write("제목 : <input type='text' name='subject'/><br/>");
        response.write("글내용 : <textarea name='content' style='width:400px; height:300px;></textarea>");
        response.write("<input type='submit' value='보내기'/>");
        response.end("</form>");
});

server.listen(12001, function(){
        console.log("start server ... http://localhost:12001?name=홍길동&tel=010-1234-5678&age=30");
});