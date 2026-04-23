var http = require('http');
const { URLSearchParams } = require('url');

var server = http.createServer(function(request, response){
        var formData = ''; // 입력받은 데이터 저장하는 변수
        // 데이터 전송 받기 
        request.on('data', function(receiveData){
                formData += receiveData;
        });
        
        // 데이터 전송이 완료되면
        request.on('end', function(){
                var params = new URLSearchParams(formData);
                console.log(params);

                response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
                response.write("<form method='post' action='http://localhost:12004'>");
                response.write("첫번째 수 : <input type='number' name='n1'/><br/> ");
                response.write("두번재 수 : <input type='number' name='n2'/><br/>");
                response.write("<input type='submit' value='사칙연산결과 확인'/>");
                response.write("</form>");
                response.write("<hr/>");
                response.write("<div style='border:1px solid gray; background-color:beige'>");
                // request한 값이 있으면 결과를 출력한다.
                var n1 = params.get('n1');
                var n2 = params.get('n2');
                if(n1 != null && n2 != null){
                        var n1 = parseInt(params.get('n1'));// 입력받은 문자 숫자로 바꿔줌
                        var n2 = parseInt(params.get('n2'));
                        var hap = n1 + n2;
                        var cha = n1 - n2;
                        var gop = n1 * n2;
                        var mok = n1 / n2; 

                        response.write(n1 + "+" + n2 + "=" + hap +"<br/>");
                        response.write(n1 + "-" + n2 + "=" + cha +"<br/>");
                        response.write(n1 + "*" + n2 + "=" + gop +"<br/>");
                        response.write(n1 + "/" + n2 + "=" + mok +"<br/>");
                        response.end("</div>"); 
                }
        });

}).listen(12004, function(){
        console.log("server start..... http://localhost:12004");
});
