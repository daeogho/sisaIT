import { useEffect, useRef, useState } from "react";
import axios from 'axios';
function JoinsEdit() {
        // 폼의 데이터를 담을 변수
        const [joins, setJoins] = useState({})
        // 이미 등록되어 있는 회원정보 db에서 가져와 폼에 표시를 해주어야 한다.
        // 페이지 로딩시 1번만 호출됨
        const mounted = useRef(false)
        useEffect(() => {
               
                        getJoins();

        }, [])
        // 회원정보 가져오기
        function getJoins() {
                axios.post('http://192.168.4.50:9988/joins/getJoins', { userid: window.sessionStorage.getItem("logId") })
                        .then((response) => {
                                console.log(response.data)
                                setJoins({
                                        id:response.data.id,
                                        userid:response.data.userid,
                                        username:response.data.username,
                                        userpwd:response.data.userpwd,
                                        tel:response.data.tel,
                                        email:response.data.email,
                                        writedate:response.data.writedate
                                })
                        })
                        .catch((error) => {
                                console.log("회원선택==>", error)
                        })
        }
        // 폼의 값을 입력하면 useState에 셋팅하는 함수

        function setFormData(event) {
                var name = event.target.name; // userid
                var value = event.target.value; //goguma

                setJoins((p) => {
                        return { ...p, [name]: value }
                });
                console.log('useState에 담긴 값-->', joins
                );
        }

        function formCheck(event) {
                //form태그의 page이동하는 기능은 비동기식으로 처리할 때는 필요없으
                event.preventDefault()
                console.log(joins)
                //유효성검사
                if (joins.userpwd == null || joins.userpwd == '') {
                        alert('비밀번호를 입력하세요...');
                        return false;
                }
                if (joins.username == null || joins.username == '') {
                        alert('이름을 입력하세요.');
                        return false;
                }
                if (joins.tel == null || joins.tel == '') {
                        alert('연락처를 입력하세요.')
                        return false
                }
                if (joins.email == null || joins.email == '') {
                        alert('이메일을 입력하세요.')
                        return false
                }
                // 백엔드 ----------------------------------------
                axios.post('http://192.168.4.50:9988/joins/joinsEdit', joins) // id, userid, userpwd, username, tel, email, writedate
                        .then(function (response) {
                                console.log("서버응답", response.data);
                                if (response.data) { //회원가입성공
                                        alert('회원정보수정에 성공하였습니다.')
                                        window.location.href = '/'
                                } else {
                                        alert('회원정보수정에 실패하였습니다.')
                                }
                        })
                        .catch(function (error) {
                                console.log('회원가입 에러발생==>', error)
                        })
        }
        //회원탈퇴
        function unRegister(){
                let que = confirm("탈퇴하시겠습니까?")
                if(que){ //비번을 입력한 경우
                        // 비밀번호, 아이디를 가지로 서버에 요청하기
                        //             http://192.168.4.22:9988/goguma/12345
                        axios.delete('http://192.168.4.50:9988/joins/unregister/'+joins.id)
                        .then((response)=>{
                                console.log(response.data)
                                if(response.data==0){// 회원이 탈퇴하면
                                        window.sessionStorage.clear();
                                        window.location.href="/";
                                }
                        })
                        .catch((error)=>{

                        })

                }
        }


        return (
                <div className='container' style={{ width: '600px' }}>
                        <h1 style={{ margin: '50px 0' }}>회원정보수정</h1>
                        <form onSubmit={formCheck}>
                                <div className="mb-3 mt-3">
                                        <label htmlFor="userid" className="form-label">아이디:</label>
                                        <input type="text" className="form-control" id="userid"
                                                placeholder="아이디를 입력하세요." name="userid"
                                                value={joins.userid||''} readOnly
                                                />
                                </div>
                                <div className="mb-3">
                                        <label htmlFor="userpwd" className="form-label">비밀번호:</label>
                                        <input type="password" className="form-control" id="userpwd"
                                                placeholder="비밀번호를 입력하세요" name="userpwd" 
                                                onChange={setFormData} />
                                </div>
                                <div className="mb-3 mt-3">
                                        <label htmlFor="username" className="form-label">이름:</label>
                                        <input type="text" className="form-control" id="username"
                                                placeholder="성명" name="username" 
                                                value={joins.username||''}
                                                onChange={setFormData} />
                                </div>
                                <div className="mb-3">
                                        <label htmlFor="tel" className="form-label">연락처:</label>
                                        <input type="text" className="form-control" id="tel"
                                                placeholder="010-1234-5678" name="tel" 
                                                value={joins.tel||''}
                                                onChange={setFormData} />
                                </div>

                                <div className="mb-3">
                                        <label htmlFor="email" className="form-label">이메일:</label>
                                        <input type="email" className="form-control" id="email"
                                                placeholder="abcd@gamail.com" name="email"
                                                value={joins.email||''}
                                                onChange={setFormData} />
                                </div>

                                <button type="submit" className="btn btn-primary">회원수정</button>
                        </form>
                        <p></p>
                        <p>
                                <button type="button" className="btn btn-success" onClick={unRegister}>회원탈퇴</button>
                        </p>
                        
                </div>
        )
}

export default JoinsEdit;