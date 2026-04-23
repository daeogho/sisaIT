
import './App.css'

function App() {
  // style시트 적용하는 방법
  // json스타일시트 속성을 만들어 적용하는 방법

  // css                  javascrpit
  // background-color     backgroundColor
  // document.getElementById("aa").style.backgroundColor = "red";
  const green = {
    backgroundColor: 'green',
    color: 'white',
    padding: '20px',
    textAlign: 'center',
    fontSize: '2em',
    height: '80px',
    lineHeight: '80px'
  }
  const a = 10;
  const b = 15;

  return (
    <>
      { /*json스타일 적용시 ""생략해야함*/}
      <div style={green}>json형식으로 만들어진 스타일 적용</div>
      {/* inline스타일 적용 : style={{속성:"속성값", 속성:"속성값"...}}*/}
      <div style={{ backgroundColor: 'blue', color: 'yellow', textAlign: 'center', fontSize: '3em' }}>inline으로 스타일 시트 적용하기</div>
      <div>
        {/* 삼항연산자 조건에 따라 실행 된다. (조건식)? 참일때 : 거짓일때 */}
        {
          a + b == 25
            ? <h2>조건식의 결과가 참입니다.</h2> //참일때
            : <h2>조건식의 결과가 거짓입니다.</h2> //거짓일때
        }
      </div>
      <div>
        {/* 조건식이 참일때만 실행되도록 하는 방법*/}
        {
          a - b == 5 && (<ol>
            <li>홈</li>
            <li>자기소개</li>
            <li>커뮤니티</li>
          </ol>)
        }
      </div>
      <hr/>
      <div>
        {
          /* 함수를 실행하여 원하는 내용을 표시하기
            (function(){
              실행문;
        })()
          
          */
         (function(){
          var hap = 0;
          for(var i=1; i<=100; i++){
            hap += i;
          }
          return (<h2>1~100까지의 합은 {hap}입니다.</h2>)
         })() /* ()() -> 람다식 함수 호출*/
        }
      </div>
      <div style={{backgroundColor:'red', color:'#fff'}}>
        {
          /* 화살표 함수로 람다식 함수 만들기 */
          ((a, b)=>{
            let result = a+b;
            return (<h2>{a}+{b}={result}</h2>)

          })(5,2)
        }
      </div>
    </>
  )
}

export default App
