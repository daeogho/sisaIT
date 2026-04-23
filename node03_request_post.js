var http = require('http');

var server = http.createServer(function(request, response){

        // post방식으로 전송받은 데이터를 누적시킬 변수

        // 폼의 데이터가 전송이 되면 'data'라는 이벤트가 발생
        //        이벤트 종류, 이벤트 발생시 실행 함수
        request.on('data', function(receiveData){
                postData += receiveData;
                console.log(receiveData, postData);
                console.log('postData', postData);

        });

        // 폼의 데이터 전송이 더 이상 일어나지 않으면 'end'라는 이벤트가 발생
        request.on('end', function(){
                // num=100&subject=12145&content=454
                var params = new URLSearchParams(postData);
                console.log(params);

                response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
                response.write("<h1>post방식으로 전송받은 값</h1>");
                response.write("번호 => " +params.get("num"));
                response.write("<br>제목 => " +params.get("subject"));
                response.end("<br>글내용 => " +params.get("content"));
        })

});

server.listen(12002, function(){
        console.log("start server... 폼방식이므로 url로 접속하면 안됨.");
})