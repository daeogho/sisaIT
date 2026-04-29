import { useState } from "react";
import axios from "axios";

function JoinsForm() {
        const [joins, setJoins] = useState({})
        // 폼의 값을 입력하면 useState에 셋팅하는 함수
        function setFormData(event){
                var name = event.target.name; // userid
                var value = event.target.value; 

                setJoins((p)=>{
                        return {...p, [name]:value}
                });
                console.log('useState 값:',joins);
        }
         // form에서 submit이벤트가 발생하면 호출할 함수
        function formCheck(event){
                //form태그의 page이동하는 기능은 비동기식으로 처리할 때는 필요 없으므로 제거한다.
                event.preventDefault()
                // 유효성검사
                if(joins.userid == null || joins.userid == ''){
                        alert("아이디를 입력하세요.");
                        return false;
                }
                if(joins.userpwd == null || joins.userpwd == ''){
                        alert("비밀번호를 입력하세요.");
                        return false;
                }
                if(joins.username == null || joins.username == ''){
                        alert("이름을 입력하세요.");
                        return false;
                }
                if(joins.tel == null || joins.tel == ''){
                        alert("연락처를 입력하세요.");
                        return false;
                }
                if(joins.email == null || joins.email == ''){
                        alert("이메일을 입력하세요.");
                        return false;
                }
                //백엔드
                
                axios.post('http://192.168.4.50:9988/joins/joinsForm',{
                        userid:joins.userid,
                        userpwd:joins.userpwd,          
                        username:joins.username,
                        tel:joins.tel,
                        email:joins.email
                })
                .then(function(response){
                        console.log(response.data);
                        if(response.data){ // 회원가입 성공
                                alert('회원가입 성공하였습니다.')
                                window.location.href='/joins/login'
                        }else{
                                alert('회원가입 실패하였습니다.')
                        }
                })
                .catch(function(error){
                        console.log('회원가입 에러발생 ==>',error)
                })
        }

        return(
                 <div className='container' style={{width:'600px'}}>
                        <h1 style={{margin:'50px 0px', textAlign:'center'}}>회원가입</h1>
                        <form onSubmit={formCheck}>
                                <div className="mb-3 mt-3">
                                        <label htmlFor="userid" className="form-label">아이디:</label>
                                        <input type="text" className="form-control" id="userid" 
                                        placeholder="아이디를 입력하세요." name="userid" 
                                        onChange={setFormData}/>
                                </div>
                                <div className="mb-3">
                                        <label htmlFor="userpwd" className="form-label">비밀번호:</label>
                                        <input type="password" className="form-control" id="userpwd" 
                                        placeholder="비밀번호를 입력하세요." name="userpwd"
                                        onChange={setFormData}/>
                                </div>
                                <div className="mb-3">
                                        <label htmlFor="username" className="form-label">이름:</label>
                                        <input type="text" className="form-control" id="username" 
                                        placeholder="이름을 입력하세요." name="username"
                                        onChange={setFormData}/>
                                </div>
                                <div className="mb-3">
                                        <label htmlFor="tel" className="form-label">연락처:</label>
                                        <input type="text" className="form-control" id="tel" 
                                        placeholder="010-1234-5678" name="tel"
                                        onChange={setFormData}/>
                                </div>
                                 <div className="mb-3">
                                        <label htmlFor="email" className="form-label">이메일 :</label>
                                        <input type="email" className="form-control" id="email" 
                                        placeholder="abcd@gmail.com" name="email"
                                        onChange={setFormData}/>
                                </div>
                        
                                <button type="submit" className="btn btn-success" >회원가입</button>
                        </form>
                </div>


        )

}
export default JoinsForm;