//image를 웹브라우저 표시하기

// http
var http = require('http');
// fs
var fs = require('fs');

var server = http.createServer(function(request, response){
//        클라이언트가 웹페이지에 접속을 하면 이미지를 파일읽기를 이용하여 읽은 후
//        response에 쓰기를 한다.
//             경로+파일명, 콜백함수
        fs.readFile(__dirname+"/img/image2.jpeg",function(error, imageCode){
                if(error){//이미지 읽기를 실패했을때
                        response.writeHead(200,{"Content-Type":"text/html; cahrset=utf-8"})
                        response.end("<h2>이미지가 존재하지 않습니다.</h2>")
                }else{//이미지 있으면
                        //클라이언트에게 보낼 데이터가 이미지일때 헤더 설정
                        response.writeHead(200, {'Content-Type':'image/jpeg'});
                        response.end(imageCode);
                }
        });
});

server.listen(12007, function(){
        console.log("server start.... http://127.0.0.1:12007");
});