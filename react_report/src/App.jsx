import { useState } from 'react'
import './assets/style.css'

function App() {
  const [formData, setFormData] = useState({ userid: '', userpwd: '' })
  const [loginIdErrorMessage, setLoginIdErrorMessage] = useState('');
  const [loginIdSuccessMessage, setLoginIdSuccessMessage] = useState('');

  const loginFormRender = (event) => {
    const name = event.target.name;
    const value = event.target.value;

    setFormData((p) => {
      return { ...p, [name]: value }
    })
    if (name == 'userid') {
      var reg = /^[A-Za-z]{1}[A-Za-z0-9_#$]{4,9}$/

      if (reg.test(value)) {
        setLoginIdSuccessMessage('사용가능한 아이디 입니다.')
        setLoginIdErrorMessage('');
      } else {
        setLoginIdErrorMessage('아이디는 5~10글자 사이며,첫 문자는 영어, 특수문자는 _,#,$만 사용가능합니다.')

        setLoginIdSuccessMessage('');
      }
    }
  }
  function loginStart(event) {
    event.preventDefault();

    if (formData.userid == '') {
      setLoginIdSuccessMessage("아이디를 입력 후 로그인하세요")
      return false;
    }
    if (formData.userpwd == '') {
      alert("비밀번호를 입력 후 로그인하세요")
      return false;
    }
  }

  return (
    <>
      <div className="signin">

        <div className="login">
          <h2 style={{ margin: "50px 0", textAlign: 'center' }}>Login</h2>
          <form method="post" onSubmit={loginStart}>
            <div className="mb-3 mt-3">
              <label for="userid">아이디:</label>
              <input type="text"
                className="form-control"
                id="userid"
                placeholder="아이디입력"
                name="userid"
                onChange={loginFormRender} />
              <div style={{ color: '#f00' }}>{loginIdErrorMessage}</div>
              <div style={{ color: '#71939C' }}>{loginIdSuccessMessage}</div>
            </div>
            <div className="mb-3">
              <label for="userpwd">비밀번호:</label>
              <input type="password" className="form-control" id="userpwd" placeholder="비밀번호 입력" name="userpwd" />
            </div>
            <div className='d-grid gap-3'>

              <button type="submit">로그인</button>
            </div>
          </form>
        </div>
        <div className="img2">
            <img src='/src/assets/img/image.jpg' />
          </div>
      </div>
    </>
  )

}

export default App
