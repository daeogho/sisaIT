// fs모듈 : 파일의 내용을 읽고, 쓰기를 할 수 있는 모듈이다.(FileSystem)
// fs모듈을 install해야한다.
// >npm install fs

var fs = require("fs");

// 파일을 입력 또는 출력하기 위해서는 파일명, 경로도 필요하다.

// [노드js 전체 전역 변수]

// [1] __filename : 현재 실행의 파일의 경로와 파일명을 절대 주소로 가지고 있다. 
// C:\study\nodeSrc\node08_file_read.js

// [2] __dirname : 현재 실행중인 파일의 경로를 절대주소로 가진다. 
// C:\study\nodeSrc
console.log("__filename =>",__filename);
console.log("__dirname =>",__dirname);

// 파일 입력
// 1.비동기식 입력
// 비동기식 파일 읽는 방법 : 읽기, 쓰기를 명령이 바로 실행되지 않고 스레드에 위해 실행된다.
//          파일명(절대경로 + 파일명),      한글인코딩, 콜백함수(에러, 읽은내용)
fs.readFile(__dirname+"/etc/text.txt", 'utf-8', function(error, data){
        // error 변수가 비어있으면 false => ""
        // error 변수에 값이 있으면 true => "fdfdsfds"
        if(error){// 에러가 발생했다.
                console.log("파일 비동기식 읽기 에러 발생...=>" + error);
        }else{// 에러가 발생하지 않았을 때
                console.log("비동기식으로 읽은 문자열=======")
                console.log(data);
        }
});

// 2.동기식으로 파일 읽는 방법 : 읽기,쓰기 명령을 만나면 바로 실행된다.
// 읽은값을 보관                     파일경로+파일명, 인코딩
try{
var readData = fs.readFileSync(__dirname+"/etc/text2.txt", 'utf-8');
console.log("동기식 파일 읽기 *****************");
console.log(readData);
}catch(error){
        console.log("파일 동기식읽기 에러 발생====>" +error);
}
