import  React from 'react';
//import './App.css'
import image1 from './assets/image1.jpeg'

function App() {
  // Jsx는 JavaScropt Xml의 약자이다.
  // Jsx는 리엑트에서 HTML태그를 쉽게 작성할 수 있도록 하는 방법이다.
  // Jsx는 내용전체가 하나의 태그에 포함되어야 한다.

  // JSX를 이용한 태그 사용하는 방법
  const element1 = <h2>HTMl은 자바스크립트에서 <i>문자열</i>로 처리해야 한다.</h2>

  const element2 = <ul>
                      <li>첫번째 js테스트중</li>
                      <li>두번쨰 목록</li>
                      <li>세번째 리스트</li>
                   </ul>

  const btn = <button>클릭하세요.</button>
  const element3 = 
  (<>
  <p>해바라기</p>
  <p>코스모스</p>
  <p>히야신스</p>
  </>)


// JSX를 사용하지 않고 태그를 생성하는 방법
// <h1 title='createElement태그 만들기'>JSX를 사용하지 않고 태그를 생성하는 방법</h1>
// React모듈의 createElement함수를 이용하여 태그를 생성할 수 있다.
// React모듈의 import하기
//                 태그명, {속성들}                       태그내의 문자열
const element4 = React.createElement('h1', {title:'createElement태그 만들기'}, 'JSX를 사용하지 않고 태그를 생성하는 방법' );
                  <img src="" title=""/>
const imgElement = React.createElement('img', {src:image1, title:'이미지에 마우스 오버됨'})
 
// 변수를 이용하여 태그만들기
let msg = 'React에서 jsx를 이용하여 태그 만드는 중....';

const element5 = <h2>{msg}</h2>

return (
    <>
      {element1}
      {element2}
      {btn}
      {element3}
      {element4}
      {imgElement}
      {element5}
    </>
  )
}

export default App
