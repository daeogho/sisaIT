var http = require('http');

// 1.이벤트가 정의되어 있는 모듈(events)을 객체 생성한다.
var events = require('events');

// 2.이벤트 처리를 하기 위해서는 events모듈내의 EventEmiter를 초기화한다.
var eventEmiter = new events.EventEmitter();

// 3.이벤트가 발생하면 실행할 함수를 만든다. -------------------------------------------
//      on(),   addListener(),  once()
//             이벤트종류,
eventEmiter.on('call',()=>{
        //call 이벤트가 발생하면 실행되는 함수
        console.log("call이벤트가 발생함...");

});

eventEmiter.addListener('check',()=>{
        console.log("check이벤트가 발생함------");
});

// 현재 서버에서 한 번만 이벤트가 발생하도록 함수를 생성 
eventEmiter.once('test',()=> {
        console.log("once()함수로 이벤트 처리하면 한번만 이벤트가 발생됨....");
});

var server = http.createServer(function(request, response){
        // emit() : 강제이벤트 발생시키기
        //              발생시킬 이벤트 종류
        eventEmiter.emit('call');
        eventEmiter.emit('check');
        eventEmiter.emit('test'); // 한번 이벤트가 발생하면  그 이후는 이벤트가 발생하지 않는다.

        response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
        response.write("<h1>이벤트 생성 및 발생</h1>");
        response.write("노드js에서 이벤트 생성하는 방법, 이벤트 발생시키기 테스트 중....");
});

server.listen(12005, function(){
        console.log("server start...... http://127.0.0.1:12005");
});