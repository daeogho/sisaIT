import axios from 'axios'
import { useEffect, useState } from 'react';

function MemberEdit(){
        //회원정보를 담을 userState훅 변수
        const [member, setMember] = useState({}) // {} {userid:'aaaa',userpwd:'ccc',username:'bbb',tel:'010-1111-2222'}

        // 이벤트가 발생하면, member에 해당 데이터를 set할 함수
        function setFormData(event){
                
               
                var name = event.target.name;
                var value = event.target.value;

                setMember((p)=>{
                        return {...p, [name]:value}
                });
                console.log(member);
        }
        // 회원가입한 기존정보를 session의 값을 이용하여 DB에서 선택하여야 한다.
        useEffect(()=>{
                getMemberData();
        },[])
        function getMemberData(){
                axios.get('http://192.168.4.86:9988/memberEdit')
                .then(function(response){
                        console.log("회원정보 수정폼==>",response)
                        setMember({
                                userid:response.data.record.userId,
                                username:response.data.record.username,
                                tel:response.data.record.tel,
                                email:response.data.record.email
                        })
                })
                .catch(function(error){
                        console.log(error)
                })
        }
        // form에서 submit이벤트가 발생하면 호출할 함수
        function formCheck(event){
                //form태그의 page이동하는 기능은 비동기식으로 처리할 때는 필요 없으므로 제거한다.
                event.preventDefault()
                // 유효성검사
                if(member.userpwd == null || member.userpwd == ''){
                        alert("비밀번호를 입력하세요.");
                        return false;
                }
                if(member.username == null || member.username == ''){
                        alert("이름을 입력하세요.");
                        return false;
                }
                if(member.tel == null || member.tel == ''){
                        alert("연락처를 입력하세요.");
                        return false;
                }
                //백엔드 ================================아이디 , 비번 , 이름, 연락처
                axios.post('http://192.168.4.86:9988/memberEditOk',member)
                .then(function(response){
                        console.log(response.data);
                        if(response.data.result=='OK'){ // 회원가입 성공
                                alert('회원정보가 수정되었습니다.')
                                window.location.href='/member/mypage'
                        }else{
                                alert('회원정보수정 실패하였습니다.')
                        }
                })
                .catch(function(error){
                        console.log('회원정보수정 에러발생 ==>',error)
                })
        }
        return(
                <div className='login' style={{width:'600px', margin:'200px auto'}}>
                        <h2 style={{textAlign:'center',fontSize:'1.5em',margin:'0px'}}>My profile</h2>
                        <h2 style={{marginBottom:'70px ', textAlign:'center',fontSize:'3em',fontWeight:'bold'}}>회원정보</h2>
                        <form onSubmit={formCheck}>
                                <div style={{color:'rgb(58, 58, 58)', margin:'10px 0',fontSize:'1.2em'}}>
                                        * 이름, 연락처, 이메일만 수정가능합니다.
                                </div>
                                <div className="mb-3 mt-3">
                                        <label htmlFor="userid" className="form-label"
                                        style={{fontWeight:'bold',fontSize:'1.2em'}}>ID</label>

                                        <input type="text" className="form-control" id="userid" 
                                        placeholder="아이디를 입력하세요." name="userid" 
                                        style={{height:'60px',width:'100%',border:'1px solid #fff',borderBottom:'3px solid #777'}}
                                        onChange={setFormData} value={member.userid} readOnly/>
                                </div>
                                <div className="mb-3">
                                        <label htmlFor="userpwd" className="form-label"
                                        style={{fontWeight:'bold',fontSize:'1.2em'}}>PASSWORD</label>

                                        <input type="password" className="form-control" id="userpwd" 
                                        placeholder="비밀번호를 입력하세요." name="userpwd"
                                        style={{height:'60px',width:'100%',border:'1px solid #fff',borderBottom:'3px solid #777'}}
                                        onChange={setFormData}/>
                                        <div style={{color:'#f00', margin:'10px 0',fontSize:'1.2em'}}>* 비밀번호 입력 후 회원정보수정 가능합니다.</div>
                                </div>
                                <div className="mb-3">
                                        <label htmlFor="username" className="form-label"
                                        style={{fontWeight:'bold',fontSize:'1.2em'}}>NAME</label>

                                        <input type="text" className="form-control" id="username" 
                                        placeholder="이름을 입력하세요." name="username"
                                        style={{height:'60px',width:'100%',border:'1px solid #fff',borderBottom:'3px solid #777'}}
                                        onChange={setFormData} value={member.username}/>
                                </div>
                                <div className="mb-3">
                                        <label htmlFor="tel" className="form-label"
                                        style={{fontWeight:'bold',fontSize:'1.2em'}}>TEL</label>
                                        <input type="text" className="form-control" id="tel" 
                                        placeholder="010-0000-0000" name="tel"
                                        style={{height:'60px',width:'100%',border:'1px solid #fff',borderBottom:'3px solid #777'}}
                                        onChange={setFormData} value={member.tel}/>
                                </div>
                                <div className="mb-3">
                                        <label htmlFor="email" className="form-label"
                                        style={{fontWeight:'bold',fontSize:'1.2em'}}>Email</label>
                                        <input type="text" className="form-control" id="email" 
                                        placeholder="abcd@gmail.com" name="email"
                                        style={{height:'60px',width:'100%',border:'1px solid #fff',borderBottom:'3px solid #777'}}
                                        onChange={setFormData} value={member.email}/>
                                </div>
                                <div style={{marginTop:'50px'}}>
                                        <button type="submit" className="btn btn-dark"
                                        style={{borderRadius:'30px',height:'60px',fontSize:'1.1em',fontWeight:'bold',width:'100px'}}>수정
                                        </button>
                                        <button onClick={()=>{window.location.href='/member/myPage'}} className="btn btn-dark"
                                        style={{borderRadius:'30px',height:'60px',fontSize:'1.1em',fontWeight:'bold',float:'right',width:'100px'}}>취소
                                        </button>
                                </div>
                        </form>
                </div>
        )


}
export default MemberEdit