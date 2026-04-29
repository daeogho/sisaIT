import { useState } from 'react'
import axios from 'axios'

        function Login() {
                // 아이디와 비밀번호를 보관할 useState변수 생성
                const [formData, setFormData] = useState({ userid: 'aaaaa', userpwd: '1234' });
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
                }

                function loginStart(event) {
                        // form태그의 기본이벤트중에 페이지 이동 기능을 해제한다.
                        event.preventDefault();


                        //아이디 존재 유무
                        if (formData.userid == '') {
                                setLoginIdSuccessMessage("아이디를 입력 후 로그인하세요.");
                                return false;
                        }
                        //비밀번호 존재 유무
                        if (formData.userpwd == '') {
                                alert("비밀번호를 입력 후 로그인하세요..");
                                return false;
                        }
                        // 백엔드
                        // 비동기식 호출 : axios, XMLHttpRequset ajax()
                        axios.post('http://192.168.4.50:9988/joins/login', formData) 
                        .then(function (response) {
                                console.log(response.data)
                                if(!response.data){
                                        alert("로그인 실패")
                                }else if(response.data){
                                        // 로그인 성공 : userid, username, logStatus
                                        // 세션 저장
                                        window.sessionStorage.setItem('id', response.data.id);
                                        window.sessionStorage.setItem('logId', response.data.userid);
                                        window.sessionStorage.setItem('logName', response.data.username);
                                        window.sessionStorage.setItem('logStatus', "Y");
                                        window.location.href = "/"
                                }
                        }).catch(function (error) {
                                console.log(error)
                        })
                }

                return (
                        <div className="container" style={{ width: '400px' }}>
                                <h2 style={{ margin: "50px 0", textAlign: 'center' }}>Login</h2>

                                <form method="post" onSubmit={loginStart}>
                                        <div className="mb-3 mt-3">
                                                <label htmlFor="userid">아이디:</label>
                                                <input type="text"
                                                        className="form-control"
                                                        id="userid"
                                                        placeholder="아이디입력"
                                                        name="userid"
                                                        value={formData.userid}
                                                        onChange={loginFormRender} />
                                                <div style={{ color: '#f00' }}>{loginIdErrorMessage}</div>
                                                <div style={{ color: 'rgb(9, 138, 9)' }}>{loginIdSuccessMessage}</div>
                                        </div>
                                        <div className="mb-3">
                                                <label htmlFor="userpwd">비밀번호:</label>
                                                <input type="password" className="form-control" id="userpwd"
                                                        placeholder="비밀번호 입력" name="userpwd"
                                                        value={formData.userpwd}
                                                        onChange={loginFormRender} />
                                        </div>
                                        <div className='d-grid gap-3'>
                                                {/*
                                        <input type="submit" value="로그인"/>
                                        <input type="button" value="로그인"/>
                                        <input type="img src=""/>

                                        <button>로그인</button>
                                        리엑트에서는 button태그가 submit이 기본으로 발행하지 않는다.
                                        */}

                                                <button type="submit" className="btn btn-success btn-block">로그인</button>
                                        </div>

                                </form>
                        </div>
                )
        }

export default Login;