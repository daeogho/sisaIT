var http = require('http');
var fs = require('fs');
var mime = require('mime');

var server = http.createServer(function (request, response) {

        var url = request.url;  // img/image1.jpeg        /movie/Wildlife.mp4
        var mapping = request.url;

        if (url == "/") { // html
                fs.readFile(__dirname + "/nodeEx02.html", 'utf-8', function (error, htmlData) {
                        if (error) {
                                response.writeHead(200, { "Content-Type": 'text/html; charset=utf-8' })
                                response.end("<h2>해당 홈페이지를 찾을 수 없습니다.</h2>")
                        } else {
                                response.writeHead(200, { 'Content-Type': 'text/html charset-utf-8' });
                                response.end(htmlData);
                        }
                });

        } else if (url.indexOf("/img") == 0){ // image
                var mimeType = mime.getType(url.substring(1));
                console.log(url, '-->', mimeType);

                fs.readFile(__dirname + url, function (error, imgCode) {
                        if (!error) {
                                response.writeHead(200, { "Content-Type": mimeType });
                                response.end(imgCode);
                        }
                });

        } else if (url.indexOf("/movie") ==0) { // video
                var stream = fs.createReadStream(mapping.substring(1));

                var mimeType = mime.getType(mapping.substring(1));
                response.writeHead(200, { 'Content-type':mimeType});

                var cnt = 0;
                stream.on('data', function(movieData){
                        response.write(movieData);
                        console.log(++cnt, '-->', movieData.length);
                });
                stream.addListener('end', function(){
                        response.end();
                        console.log('영상 전송 완료...');
                });
                stream.on('',function(){
                        response.end();
                        console.log("읽기 에러 발생....")
                });
        }

});
server.listen(12010, function() {
        console.log("server start... http://127.0.0.1:12011/");
})