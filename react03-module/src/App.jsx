import {name, age} from './person.js';
// import {name} from '/person.js'; // 일부만 사용가능하다.

import {tel, addr} from './person.js';
// import {tel, addr} from './person.js'; // 일부만 사용가능하다.

import message from './person.js';
import message2 from './person.js';
function App() {

  return (
    <>
    <p>이름 : {name}</p>
    <p>나이 : {age}</p>
    <p>연락처 : {tel}</p>
    <p>주소 : {addr}</p>
    <p>{message()}</p>
    <p>{message2()}</p>
    </>
  )
}

export default App
