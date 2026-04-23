var http = require('http');
var fs = require('fs');
var mime = require('mime');

var server = http.createServer(function (request, response) {
        var mapping = request.url;
        // /로 접속시 html문서를 응답
        if (mapping == "/") {
                fs.readFile('movie_play.html', 'utf-8', function (error, htmlCode) {
                        if (error) {
                                response.writeHead(200, { 'ContentType': 'text/html; charset=utf-8' });
                                response.end('<h2>웹페이지가 존재하지 않습니다.</h2>');
                        } else {
                                response.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
                                response.end(htmlCode);

                        }
                })
        } else if (mapping.indexOf("/movie") == 0) { // /movie/Wildlife.mp4로 접속하면 동영상을 스티리밍으로 전송한다.
                //                                 /movie/Wildlife.mp4
                // 스트리밍 : 동영상은 파일의 용량이 크므로 한번에 전송하지 않고 여러번 나누어 전송한다.
                //           한번에 65535byte 크기를 전송한다.

                // 스트리밍으로 읽기 처리를 할 파일을 생성한다.
                var stream = fs.createReadStream(mapping.substring(1)); // movie/Wildlife.mp4

                var mimeType = mime.getType(mapping.substring(1));

                response.writeHead(200, { 'Content-Type': mimeType });

                // 이벤트 방식으로 전송
                // data이벤트 : 읽은 정보가 있을때
                var cnt = 0; // 전송횟수를 계산할 변수
                stream.on('data', function (movieData) {
                        response.write(movieData);
                        console.log(++cnt,'-->', movieData.length);
                });

                // end 이벤트 : 마지막에 알리는 이벤트
                stream.addListener('end', function(){
                        response.end();
                        console.log('영상 전송 완료...');
                });
                // 에러발생시 구현한 이벤트
                stream.on('',function(){
                        response.end();
                        console.log("읽기 에러 발생....")
                });
        }
});

server.listen(12009, function () {
        console.log("start running... http://localhost:12009/");
});