import {useState} from 'react'

function UseStateHookTest(){
        // 하나의 변수에 값이 여러개 일때 useState훅 변수의 데이터 처리
        const[myInfor, setMyInfor] = useState({
                username : '강감찬',
                userid : 'gang',
                tel : '010-7896-7777',
                email : 'gang@gmail.com',
                addr : '서울시 영등포구 여의도동'
        });
        // 일부 데이터를 변경하더라도 나머지 데이터를 유지하도록 처리하는 함수
        function updateInfor(){
                // 연락처 : 010-8888-9999, 이메일 : leesunsin@naver.com

                // setMyInfor() 매개변수를 함수로 만든다.
                setMyInfor((previous)=>{
                        // 이전데이터를 가진 previous변수를 spread(...)연사자와 함께 사용하면 기존 데이터가 보전된다.
                        return{...previous, username:'손아섭',userid:'kklk'}
                });

                // 데이터 보존 상태에서 1개의 값만 수정
                function inforChange(key,data){
                        setMyInfor((prev)=>{
                                if(key==1) return {...prev, username:data}
                                if(key==2) return {...prev, userid:data}
                                if(key==3) return {...prev, tel:data}
                                if(key==4) return {...prev, email:data}
                                if(key==5) return {...prev, addr:data}
                        });
                }
          
        }
        return(
                <div>
                        <ol>
                                <li>이름 : {myInfor.username}</li>
                                <li>아이디 : {myInfor.userid}</li>
                                <li>연락처 : {myInfor.tel}</li>
                                <li>이메일 : {myInfor.email}</li>
                                <li>주소 : {myInfor.addr}</li>
                        </ol>
                        <hr/>
                        <h2>데이터 1개만 수정하기 : 나머지 데이터는 사라진다</h2>
                        <button onClick={()=>setMyInfor({tel:'010-4567-1111'})}>연락처 변경하기</button>
                        <button onClick={()=>setMyInfor({username:'이순신', userid:'sunsin', tel:'010-5555-6666', email:'sunsin@nate.com', addr:'서울시 종로구 통인동'})}>전체 정보</button>
                        <h2>기존 데이터를 보존하면서 일부 데이터 수정하기</h2>
                        <button onClick={updateInfor}>기존 데이터를 보존하고 수정</button>
                        <hr/>
                        <h2>기존 데이터를 보조하면서 1개씩만 수정하기</h2>
                        <button onClick={()=>inforChange(1,'세종대왕')}>이름 변경</button>
                        <button onClick={()=>inforChange(2,'king')}>아이디 변경</button>
                        <button onClick={()=>inforChange(3,'010-4537-3121')}>연락처 변경</button>
                        <button onClick={()=>inforChange(4,'king@naver.com')}>이메일 변경</button>
                        <button onClick={()=>inforChange(5,'경기도 화성시 봉담읍')}>주소 변경</button>
                </div>
        )
}

export default UseStateHookTest