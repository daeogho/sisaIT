// 웹서버의 기능을f 가진 http모듈을 객체를 생성한다.
var http = require('http'); // http.js

// 2. http객체의 createServer()함수를 이용하여 서버를 생성한다.
//                        request : 클라이언트측의 정보를 서버로 가져올 수 있다.
//                        response : 서버에서 클라이언트측으로 정보를 보낼 수 있다.
var server =http.createServer(function(request, response){
        console.log("클라이언트가 서버에 접속하였습니다.");
        // 1.Head보내기
        // 200 : 정상전송
        response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
        // 2. 홈페이지 내용 보내기
        response.write("<h1>노드서버에서 클라이언트에게 보낸 내용</h1>");
        response.write("http 모듈을 이용하여 require()함수로 객체를 생성 후 server를 생성한다.");
        // 3. 마지막 전송이다.
        response.end("The end....");
})

// 3. 클라이언트가 접속할 수 있도록 대기하고 있다.
// 0~65555의 값중 1개를 열어놓는다.
server.listen(5500, function(){
        //                                ctrl + click
        console.log("server start.... http://127.0.0.1:5500");
});

