import { useState } from 'react'

function Login() {
        // 아이디와 비밀번호를 보관할 useState변수 생성
        const [formData, setFormData] = useState({userid: '', userpwd: ''});
        const [loginIdErrorMessage, setLoginIdErrorMessage] = useState(''); //에러할때
        const [loginIdSuccessMessage, setLoginIdSuccessMessage] = useState(''); // 적합할때

        // 사용자가 폼에 값을 입력하면 useState변수에 대입하는 함수
        const loginFormRender = (event) => {
                // event변수의 input태그의 name속성의 값을 구하여 
                //             아이디 박스면 userid, 비밀번호 박스면 userpwd의 값을 변경
                const name = event.target.name; //userid = key
                const value = event.target.value; // value = value

                setFormData((p) => {
                        //        spread연산자
                        return { ...p, [name]: value }
                })
                if (name=='userid') { //아이디가 입력되었을때
                        // 아이디가 유효성적합한지 확인하여 에러메시지표시 => 영어,숫자,_만허용,8~12글자까지 허용
                        var reg = /^[A-za-z}{1}[A-Za-z0-9_]{7,11}$/

                        if (reg.test(value)) { //true->적합하다. false:정규적합식에 위배된다.
                                setLoginIdSuccessMessage('사용가능한 아이디 입니다.');
                                setLoginIdErrorMessage('');
                        } else {
                                setLoginIdErrorMessage('아이디는 8~12글자 사이이며, 영대소문자,숫자, _만 허용');
                                setLoginIdSuccessMessage('');
                        }
                }
                console.log(formData)
        }

        function loginStart(event){
                // form태그의 기본이벤트중에 페이지 이동 기능을 해제한다.
                event.preventDefault();


                //아이디 존재 유무
                if(formData.userid==''){
                        setLoginIdSuccessMessage("아이디를 입력 후 로그인하세요.");
                        return false;
                }
                //비밀번호 존재 유무
                if(formData.userpwd==''){
                        alert("비밀번호를 입력 후 로그인하세요..");
                        return false;
                }
                // 백엔드
                // 비동기식 호출 : axios, XMLHttpRequset ajax()
        }

        return (
                <div class="container mt-3" style={{ width: '400px' }}>
                        <h2 style={{ margin: "50px 0", textAlign: 'center' }}>Login</h2>
                        
                        <form method="post" onSubmit={loginStart}>
                                <div class="mb-3 mt-3">
                                        <label for="userid">아이디:</label>
                                        <input type="text"
                                                class="form-control"
                                                id="userid"
                                                placeholder="아이디입력"
                                                name="userid"
                                                onChange={loginFormRender} />
                                        <div style={{ color: '#f00' }}>{loginIdErrorMessage}</div>
                                        <div style={{ color: 'rgb(9, 138, 9)' }}>{loginIdSuccessMessage}</div>
                                </div>
                                <div class="mb-3">
                                        <label for="userpwd">비밀번호:</label>
                                        <input type="password" class="form-control" id="userpwd" placeholder="비밀번호 입력" name="userpwd" />
                                </div>
                                <div class='d-grid gap-3'>
                                        {/*
                                        <input type="submit" value="로그인"/>
                                        <input type="button" value="로그인"/>
                                        <input type="img src=""/>

                                        <button>로그인</button>
                                        리엑트에서는 button태그가 submit이 기본으로 발행하지 않는다.
                                        */}

                                        <button type="submit" class="btn btn-success btn-block">로그인</button>
                                </div>

                        </form>
                </div>
        )
}

export default Login;