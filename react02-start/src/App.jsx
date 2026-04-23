import './App.css'
// 사용할 이미지 import하기
import jutopia from './assets/img/image1.jpeg'

function App() {
  // 변수선언(const, let, var), 함수선언
  let user_name = "이순신";
  // 함수선언
  function myWelcome() {
    let hello = '어서오세요.. 환영합니다.';
    return hello;
  }

  return (<div>
    <ul>
      <li>React는 프론트엔드 자바스크립트 라이브러리이다.</li>
      <li>유저의 행동흐름에 따라서 동적으로 화면을 보여줄 수 있다.</li>
      <li>
        <h2>리엑트에서 선언한 변수 사용하기</h2>
        {/* return 영역에 주석문은 {}내에 기술한다. */}
        이름(user_name) : {user_name}
        <hr/>
        함수호출 : {my}
      </li>
      <li>
        <ol>
          <li> npm create vite@latest react프로젝트명</li>
        </ol>
      </li>
    </ul>
    <img src={jutopia}/>
  </div>)
};

export default App  