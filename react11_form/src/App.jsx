import { useState } from 'react'
import './App.css'

// form의 데이터를 useState훅변수에 대입하는 방법
function App() {
  //1명의 회원을 보관할 변수
  const [member, setMember] = useState({username: '', tel: '', addr: '' }); //{username:'ddffd}, tel:'fdsfds', addr:'fkdls'

  // form의 입력값을 member변수 담기를 한다.
  const setFormData = (event) => {
    // 이벤트가 발생한 input박스는 event변수에 담기고 
    const fieldName = event.target.name; // name속성의 값을 구한다. username, tel, addr
    const fieldValue = event.target.value; // value속의 값을 구한다.
    setMember((previous) => {
      // return {...previous, username:'홍'}
      //                      'username:'홍' -> username:'홍'
      return { ...previous, [fieldName]: fieldValue }

    });
    console.log(fieldName, fieldValue);
    console.log(member);
  }

  // 폼의 유효성 검사
  const formCheck = (event) => {
    //for태그 기본기능에 action속상값에 설정된 페이지로 이동하는 기능을 해제
    event.preventDefault();

      if (member.username == "") {
        alert("이름을 입력하세요..");
        return false;
      }
      if (member.tel == "") {
        alert("연락처를 입력하세요");
        return false;
      }
      if (member.addr == "") {
        alert("주소를 입력하세요..");
        return false;
      }
      // 비동기식으로 백엔드 수행
    }

  return (
    <> <h1>폼의 데이터 처리</h1>
      <form>
        이름 : <input type="text" name="username" id="username" onChange={setFormData} /><br />
        연락처 : <input type="text" name="tel" id="tel" onChange={setFormData} /><br />
        주소 : <input type="text" name="addr" id="addr" onChange={setFormData} /><br />
        <button>등록하기</button>
      </form>
    </>
  )
}

export default App
