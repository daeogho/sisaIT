var http = require('http');
// 사용할 모듈을 객체를 생성한다. 확장자를 제외하고 경로와 파일명을 기술한다.
var myModule =require("./node04_module_create")
var server = http.createServer(function(request, response){
        var code = myModule.productCode;
        var name = myModule.productName;

        var plus = myModule.plus(154,13);
        var minus = myModule.minus(45,5);

        var gugudan = myModule.gugudan(6)

        response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
        response.write("<div>상품코드 = " + code + "</div>");
        response.write("<div>상품명 = " +name+"</div>");

        response.write("<div>154 + 13 = "+plus+"</div>");
        response.write("<div>45 - 5= " +minus+"</div>");

        response.end(gugudan);

}).listen(12003, function(){
        console.log("start server..... http://localhost:12003")
})