// 사용자 정의 모듈 만들기
// 변수, 함수를 모듈로 생성할 수 있다.
// 모듈은 변수명이나 함수명에 exports를 키워드를 붙이면 된다.

// 변수선언하고 모듈로 만드는 방법
exports.productCode = 12345;
exports.productName = "노트북";

// 2. 함수를 모듈로 만드는 방법
// 두수를 매개변수로 전달받아 두수의 합을 구하여 리턴하는 함수
exports.plus = (a,b)=>{
        return a+b;
}

exports.minus = function(x,y){
        return x-y;
}
function multiple(i, j){
        return i*j;
}

// 단을 입력받아 구구단을 구하는 함수
exports.gugudan = (dan)=>{
        let result = "<ul>";
        for(var i=1; i<=9; i++){
                result += "<li>" +dan+ "*" +i+ "=" + multiple(dan, i)+"</li>";
        }
        result += "</ul>"
        return result;
}