
var http =require('http');
var fs = require('fs');
// mime모듈 추가하기
// >npm install mime@2
var mime = require('mime');

var server = http.createServer(function(request, response){
//          http://127.0.0.1:12008/
//          http://127.0.0.1:12008/img/image1.jpeg
//          http://127.0.0.1:12008/img/image2.jpeg
//          http://127.0.0.1:12008/img/image3.gif
        var url =request.url;
        console.log("url=>", url);

        if(url=="/"){// index.html을 읽어서 response로 보낸다.
                fs.readFile(__dirname+"/index.html",'utf-8',function(error, htmlData){
                        if(error){
                                response.writeHead(200, {"Content-Type":"text/html; charset=utf-8"});
                                response.end("<h2>해당페이지가 존재하지 않습니다.</h2>");
                        }else{
                                response.writeHead(200, {'Content-Type' : 'text/html; charset=utf-8'});
                                response.end(htmlData);
                        }
                });
        }else if(url.indexOf("/img")==0){//요청주소가 /img로 요청되면 이미지를 요청하는 것이다.
                // 이미지 확장자가 png, jpg, jpeg, gif,.... 등 종류가 많으므로 mime이라는 모듈을 
                // 이용하여 확장자를 종류를 구한 후 Content-Type에 적용한다.

                // /img/image1.jpeg -> img/image1.jpeg
                var mimeType = mime.getType(url.substring(1));
                console.log(url, '-->',mimeType);

                // 이미지 파일 읽기
                fs.readFile(__dirname+url,function(error, imgCode){
                        if(!error){// 이미지가 존재하면
                                response.writeHead(200, {"Content-Type": mimeType});
                                response.end(imgCode);
                        }
                });

        }
});

server.listen(12008, function(){
        console.log("server start..... http://127.0.0.1:12008/");
})