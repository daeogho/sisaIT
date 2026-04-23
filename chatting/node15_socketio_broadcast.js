var http = require('http');
var fs = require('fs');
var server = http.createServer(function (request, response) {
        if (request.url == "/chatform") {
                fs.readFile(__dirname + '/chattingForm.html', 'utf-8', function (error, data) {
                        if (!error) {
                                response.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
                                response.end(data);
                        }
                });
        }
});

server.listen(12013, function () {
        console.log("chatting server start.... http://127.0.0.1:12013/chatform")
});

//-------------채팅 프로그램 만들기------------------------------
// 모듈을 install하기
// >npm install socket.io@2

// 1) 채팅을 하기위해 필요한 모듈 객체를 만든다.
var socketio = require("socket.io");

// 2) server를 이용하여 소켓서버를 생성한다.
var io = socketio.listen(server);

// 3) 접속을 대기하는 이벤트 생성 -> on(), addListener(), once()
io.sockets.on('connection', (socket)=>{
        console.log("클라이언트가 접속했습니다.");

        // 클라이언트 문자를 보내면 받을 이벤트를 구현한다.
        socket.on('hello', function(msg){
                console.log(msg);
                // 클라이언트에게 서버가 문자보내는 이벤트 발생시킴
                // [1:1통신]
                // socket.emit('hi','[1:1통신]>>서버가 받는 메시지야 ->'+ msg);
                // [1:n통신] : 
                // io.sockets.emit('hi', '[1:n통신]>>'+msg);
                // [Broadcast통신] : 나를 제외한 다른 모든 접속자에게 데이터보내기
                socket.broadcast.emit('h1','[Broadcast]>>' + msg);
        });
});