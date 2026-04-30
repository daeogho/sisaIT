import { useState } from 'react'
import axios from 'axios'

function Member() {
        // 회원정보를 담을 useState훅 변수

        const [member, setMember] = useState({})
        const [loginIdErrorMessage, setLoginIdErrorMessage] = useState(''); // 부적합할 때
        const [loginIdSuccessMessage, setLoginIdSuccessMessage] = useState(''); // 적합할 때

        const [loginPwdErrorMessage, setLoginPwdErrorMessage] = useState(''); //비번 부적합할 때
        const [loginPwdSuccessMessage, setLoginPwdSuccessMessage] = useState(''); //비번 적합할 때

        // 사용자가 폼에 값을 입력하면 useState변수에 대입하는 함수
        const loginFormRender = (event) => {
                // event 변수의 input태그의 name속성의 값을 구하여
                //             아이디 박스면 userid, 비밀번호 박스면 userpwd의 값을 변경
                const name = event.target.name; // userid = key
                const value = event.target.value; // value = value

                setMember((p) => {
                        // spread 연산자    (...)이전 데이터 보존 됨
                        return { ...p, [name]: value }
                })

                if (name == 'userid') {//아이디가 입력되었을 때

                        // 아이디가 유효성에 적합한지 확인하여 에러메세지 표시 => 영어,숫자,_만 허용,8~12글자까지 허용
                        var reg = /[A-Za-z0-9]{5,10}$/

                        if (reg.test(value)) { // true -> 적합하다.       false:위배된다.
                                setLoginIdSuccessMessage('사용가능한 아이디입니다.');
                                setLoginIdErrorMessage('');
                        } else {
                                setLoginIdErrorMessage('아이디는 5~10글자만 가능합니다');
                                setLoginIdSuccessMessage('');
                        }
                }
                else if (name == 'userpwd') {// 비밀번호가 입력되었을 때
                        var reg = /^[A-Za-z0-9!@#]{8,12}$/

                        if (reg.test(value)) { // true -> 적합하다.       false:위배된다.
                                setLoginPwdSuccessMessage('사용가능한 비밀번호입니다.');
                                setLoginPwdErrorMessage('');
                        } else {
                                setLoginPwdErrorMessage('비밀번호는 8~12글자 사이이며, 영대소문자, 숫자, !@#만 허용');
                                setLoginPwdSuccessMessage('');
                        }

                }

        }

        function formCheck(event) {

                event.preventDefault()
                //유효성검사
                if (member.userid == null || member.userid == '') {
                        alert("아이디를 입력하세요..");
                        return false;
                }
                if (member.userpwd == null || member.userpwd == '') {
                        alert('비밀번호를 입력하세요...');
                        return false;
                }
                if (member.username == null || member.username == '') {
                        alert('이름을 입력하세요.');
                        return false;
                }
                if (member.tel == null || member.tel == '') {
                        alert('연락처를 입력하세요.')
                        return false
                }
                // 백엔드 ----------------------------------------

                axios.post('http://192.168.4.86:9988/member', member)
                        .then(function (response) {
                                console.log(response.data);
                                if (response.data.result == 'success') {
                                        alert('회원가입에 성공하였습니다.')
                                        window.location.href = '/member/login'
                                } else {
                                        alert('회원가입에 실패하였습니다.')
                                }
                        })
                        .catch(function (error) {
                                console.log('회원가입 에러발생==>', error)
                                alert('ID가 중복되었습니다.')
                        })
        }

        // -------------------------------------------------------------------------------------------------------------
        return (
                <div className='container' style={{
                        minHeight: '90vh',
                        display: 'flex',
                        flexDirection: 'column',
                        justifyContent: 'center',
                        alignItems: 'center',
                }}>
                        <h2 style={{
                                letterSpacing: '4px',
                                fontSize: '2em',
                                margin: '0',
                        }}>HOME LOG</h2>

                        <h2 style={{
                                marginBottom: '50px',
                                fontWeight: 'bold',
                                fontSize: '4em',
                        }}>REGISTER</h2>

                        <form onSubmit={formCheck} style={{ width: '100%' }}>
                                {/*가입 박스폼 */}
                                <div style={{
                                        width: '800px',
                                        padding: '60px 40px',
                                        border: '1px solid #003631',
                                        borderRadius: '50px',
                                        display: 'flex',
                                        flexDirection: 'column',
                                        alignItems: 'center',
                                        margin: '0 auto'
                                }}>
                                        {/* 아이디 */}
                                        <div style={{
                                                width: '100%',
                                                maxWidth: '500px',
                                                display: 'flex',
                                                flexDirection: 'column',
                                                marginBottom: '30px'
                                        }}>
                                                <label for="userid" style={{ fontWeight: 'bold', fontSize: '1.2em' }}>ID</label>
                                                <input type="text" id="userid"
                                                        placeholder="아이디를 입력하세요." name="userid"
                                                        onChange={loginFormRender}
                                                        style={{
                                                                height: '60px',
                                                                border: '1px solid #fff',
                                                                borderBottom: '3px solid #777',
                                                                fontSize: '1rem',
                                                                padding: '0 10px'
                                                        }} />
                                                <div style={{ color: '#f00', margin: '10px 0', fontSize: '1.2em' }}>{loginIdErrorMessage}</div>
                                                <div style={{ color: 'rgb(15, 182, 15)', margin: '10px 0', fontSize: '1.2em' }}>{loginIdSuccessMessage}</div>
                                        </div>
                                        {/* 비밀번호 */}
                                        <div style={{
                                                width: '100%',
                                                maxWidth: '500px',
                                                display: 'flex',
                                                flexDirection: 'column',
                                                marginBottom: '30px'
                                        }}>
                                                <label for="userpwd" style={{ fontWeight: 'bold', fontSize: '1.2em' }}>PASSWORD</label>
                                                <input type="password" className="form-control" id="userpwd"
                                                        placeholder="비밀번호를 입력하세요" name="userpwd"
                                                        onChange={loginFormRender}
                                                        style={{
                                                                height: '60px',
                                                                border: '1px solid #fff',
                                                                borderBottom: '3px solid #777',
                                                                fontSize: '1rem',
                                                                padding: '0 10px'
                                                        }} />
                                                <div style={{ color: '#f00', margin: '10px 0', fontSize: '1.2em' }}>{loginPwdErrorMessage}</div>
                                                <div style={{ color: 'rgb(15, 182, 15)', margin: '10px 0', fontSize: '1.2em' }}>{loginPwdSuccessMessage}</div>
                                        
                                        </div>
                                {/* 비밀번호 체크
                                        <div style={{
                                                width: '100%',
                                                maxWidth: '500px',
                                                display: 'flex',
                                                flexDirection: 'column',
                                                marginBottom: '30px'
                                        }}>
                                                <label for="userpwdckd" style={{ fontWeight: 'bold', fontSize: '1.2em' }}>PASSWORD CHECK</label>
                                                <input type="password" className="form-control" id="userpwdckd"
                                                        placeholder="비밀번호를 입력하세요" name="userpwdckd"
                                                        onChange={setFormData}
                                                        style={{
                                                                height: '60px',
                                                                border: '1px solid #fff',
                                                                borderBottom: '3px solid #777',
                                                                fontSize: '1rem',
                                                                padding: '0 10px'
                                                        }} />
                                        </div> */}
                                {/* 이름 */}
                                <div style={{
                                        width: '100%',
                                        maxWidth: '500px',
                                        display: 'flex',
                                        flexDirection: 'column',
                                        marginBottom: '30px'
                                }}>
                                        <label for="username" style={{ fontWeight: 'bold', fontSize: '1.2em' }}>NAME</label>
                                        <input type="text" className="form-control" id="username"
                                                placeholder="성명" name="username"
                                                onChange={loginFormRender}
                                                style={{
                                                        height: '60px',
                                                        border: '1px solid #fff',
                                                        borderBottom: '3px solid #777',
                                                        fontSize: '1rem',
                                                        padding: '0 10px'
                                                }} />
                                </div>
                                {/* 전화번호 */}
                                <div style={{
                                        width: '100%',
                                        maxWidth: '500px',
                                        display: 'flex',
                                        flexDirection: 'column',
                                        marginBottom: '30px'
                                }}>
                                        <label for="tel" style={{ fontWeight: 'bold', fontSize: '1.2em' }}>TEL</label>
                                        <input type="text" className="form-control" id="tel"
                                                placeholder="010-1234-5678" name="tel"
                                                onChange={loginFormRender}
                                                style={{
                                                        height: '60px',
                                                        border: '1px solid #fff',
                                                        borderBottom: '3px solid #777',
                                                        fontSize: '1rem',
                                                        padding: '0 10px'
                                                }} />
                                </div>
                                {/* 이메일 */}
                                <div style={{
                                        width: '100%',
                                        maxWidth: '500px',
                                        display: 'flex',
                                        flexDirection: 'column',
                                        marginBottom: '30px'
                                }}>
                                        <label for="email" style={{ fontWeight: 'bold', fontSize: '1.2em' }}>E-MAIL</label>
                                        <input type="text" className="form-control" id="email"
                                                placeholder="homelog@home.log" name="email"
                                                onChange={loginFormRender}
                                                style={{
                                                        height: '60px',
                                                        border: '1px solid #fff',
                                                        borderBottom: '3px solid #777',
                                                        fontSize: '1rem',
                                                        padding: '0 10px'
                                                }} />
                                </div>

                                <button type="submit" className="btn btn-dark"
                                        style={{
                                                borderRadius: '20px',
                                                width: '300px',
                                                height: '60px',
                                                fontSize: '1.5em',
                                                fontWeight: 'bold',
                                                marginTop: '50px',
                                                backgroundColor: '#003631',
                                                cursor: 'pointer'
                                        }}>가입하기</button>
                </div>
                        </form >
                </div >
        )
}
export default Member