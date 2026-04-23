/*
  React의 useState훅을 사용하면 함수의 데이터 상태를 추적 할 수 있다.
          useState훅으로 생성된 변수의 값이 변경되면 render된 데이터가 자동으로 가능하다.
          userState훅은 별도로 import해야한다
          
          import {useState} from 'react'

*/

import { useState } from 'react'
import UseStateHookTest from './useStateHookTest'

function App() {
  let username = '세종대왕'

  const usernameChange = (name) => {
    username = name
    console.log('username=>', username);
  }
  // -------------------------------------------
  // useState훅으로 변수 선언하는 방법
  //      변수    color변수의 값을 변경할 수 있는 함수 setColor()
  const [color, setColor] = useState();
  const [color1, setColor1] = useState('BLUE');
  const [color2, setColor2] = useState('');
  const [color3, setColor3] = useState([]);
  const [color4, setColor4] = useState({});
  console.log('color->', color); // undefined
  console.log('color1->', color1); // 'BLUE'
  console.log('color2->',color2); // ''
  console.log('color3->',color3); // []
  console.log('color4->',color4); // {}

  const [color5, setColor5] = useState([1,2,3,4,{product:'컴퓨터', place:1500}]); 
  const [color6, setColor6] = useState({name:'hong', tel:'02-111-1111'});

  console.log('color5->', color5);
  console.log('color6->', color6);

  const [addr, setAddr] = useState('강남구 역삼동');

  function colorChange(clr){
    setColor1(clr);
    console.log(color1)
    }

  const addrChange=(juso)=>{
    setAddr(juso);
  }

  return (
    <>
      <h1>기본형으로 선언한 변수의 경우</h1>
      <div>일반변수는 render한 값이 변경되더라도 수정되지 않는다.</div>
      <h2>이름(username) : {username}</h2>
      {<button onClick={() => usernameChange('이순신')}>이름을 변경하기</button>}
      <hr />
      <h1 style={{backgroundColor:color1}}>useState훅으로 선언한 변수의 경우</h1>
      <h2>컬러명 : {color1}</h2>
      <h2>주소 : {addr}</h2>
      <button onClick={()=>colorChange('yellow')}>컬러명 변경하기</button>
      <button onClick={()=>addrChange('송파구 잠실동')}>주소변경하기</button>
      <hr/>
      <UseStateHookTest/>
    </>
  )
}

export default App
