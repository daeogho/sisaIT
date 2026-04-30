import { useCallback, useEffect, useRef, useState } from 'react';
import '../css/Chatting.css'
/*websocket 채팅 import  
        SockJS와 Stomp를 이용하여 서버에 접속하고 메세지를 주고 받는 기능을 수행한다.
*/ 
import {Stomp} from '@stomp/stompjs'
import SockJS from 'sockjs-client/dist/sockjs' 

function Chatting(){
      
        // 아이콘과 대화 상자 표시 여부
        const [isVisible, setIsVisible] = useState(true);
        // 접속전 닉네임, 참가버튼 활성화, 접속 후에는 비활성화
        // 접속 전 메세지, 보내기 버튼 비활성화 , 접속 후 활성화
        const [isJoin, setIsJoin] = useState(true);

        // 상태변수 선언
        const [sender, setSender] = useState(''); // 접속자 닉네임 변수 
        const [message, setMessage] = useState('') // 채팅 메세지 보관할 변수
        const [chatHistory, setChatHistory] = useState([])// 대화 목록을 보관할 변수

        // ref변수 선언
        const refSenderInput = useRef() // 닉네임
        const refMessageInput = useRef() // 메세지
        const refDialogDiv = useRef() // 리스트
        const stompClient = useRef(null) // 스톰 : 채팅유지

        // 아이콘 숨기고 대화상자 보여주기 위해서는 isVisible를 false로 설정하면 된다.
        const handleIsVisible = () =>{
                setIsVisible(!isVisible)

                // 종료처리 
                stompClient.current.send('/app/chat.leaveUser',{},JSON.stringify({sender:sender,type:'LEAVE'}));
                handleIsJoin()
                setSender('')
                setMessage('')
                setChatHistory([])

        }
        const handleIsJoin = () =>{
                setIsJoin(!isJoin)
        }
        // 채팅참여 
        const joinChatting = useCallback(()=>{
                if(!sender){
                        alert("닉네임 입력 후 참가하세요.")
                        refSenderInput.current.focus()// 닉네임 입력박스 커서 넣기
                        return false
                }
                // 채팅 서버에 접속
                // 채팅 서버 객체를 sockJS 객체로 생성하여 ref변수에 담아놓는다. 스프링에 접속 : /ws
                stompClient.current = Stomp.over(()=> new SockJS('http://43.202.150.110:9988/ws'))

                // 서버에 접속하기
                stompClient.current.connect({}, onConnected, onError)

        },[sender])

        // 채팅 서버에 연결되면 호출할 콜백 함수
        const onConnected = useCallback(()=>{
                console.log("채팅 서버에 연결됨")
                // 닉네임,참가 버튼 비활성화
                // 메세지,보내기 버튼 활성화
                handleIsJoin()
                // 서버에서 문자를 받을 주소를 구독한다.
                stompClient.current.subscribe('/topic/chatting', onMessageReceived)

                // 참가자 정보 보내기 : 참가자 정보를 /chat.addUser 매핑주소를 이용하여 서버 전송
                //                         매핑 주소,        서버로 전송할 데이터
                stompClient.current.send('/app/chat.addUser',{},JSON.stringify({sender:sender,type:'JOIN'}))


        },[sender])
        
        // 채팅 서버에 연결 실패시 호출할 콜백 함수
        const onError = useCallback(()=>{
                console.log("채팅서버에 접속 실패")
        },[])
        // 응답 메세지 처리 함수
        const onMessageReceived = useCallback((payload)=>{
                console.log(payload)
                const message = JSON.parse(payload.body) // 받은 메세지 객체로 변환;
                console.log(message)
                // 채팅서버에 담을 내용을 chatHistory에 담는다.

                // 내가 접속자
                // if(message.type =="JOIN" && message.sender === sender){
                //         if(message.history !=null){
                //                 message.history.map( msg => {
                //                         setChatHistory(chatHistory=>[...chatHistory, msg])
                //                 })
                //         }
                // }else{ // 본인이 아닐때
                        setChatHistory(chatHistory=>[...chatHistory, message])
                        console.log(chatHistory)
                //}
        },[sender])

        //메세지 보내기
        const sendMessage = useCallback((e)=>{
                // 메세지 보내기
                // 채팅 메세지를 서버로 전송
                if(stompClient){
                        //                                                  서버에 보낼문자(글쓴이, 메세지)
                        stompClient.current.send('/app/chat.sendMessage',{},JSON.stringify({sender:sender, message, type:'CHAT'}))
                        // 이미 입력된 문자 초기화
                        setMessage('')
                        if(e.key === 'Enter') e.preventDefault() // 엔터키로 줄바꿈 방지
                
                }
        },[message])
       
        // 자동 스크롤
        useEffect(()=>{
                if(refDialogDiv.current){
                        refDialogDiv.current.scroll({
                                top: refDialogDiv.current.scrollHeight,
                                behavior: 'smooth'
                        })
                }
        },[chatHistory])

        return (
                <div className="container"> 
                <img src="/img/jeju23.jpg" style={{width:'100%', height:'100%'}}/>
                        {/** 채팅창 아이콘 : isVisible이 true일 때 아이콘 */}
                        {
                            (isVisible)
                             &&( <img src="/img/chat-icon.png" id="chat_icon" onClick={handleIsVisible}
                                        style={{cursor:'pointer'}}/>)
                        }

                       
                        
                        {/**채팅 창 */}
                        {
                                (!isVisible)
                                && (<div id="chat-wrap">
                                        <div id="chat">
                                                <div className="chat-close">
                                                        <b onClick={handleIsVisible}>나가기</b>
                                                </div>       
                                                <div id="dialog" ref={refDialogDiv}>
                                                        <div className='dialog-board' >
                                                        {/**메세지 목록 */}
                                                        {
                                                                chatHistory.map((chat, idx)=>{
                                                                return  <div key={idx} className={chat.sender === sender ? "me" : "other"}>
                                                                              <span><b><i>{chat.sender}</i></b></span>
                                                                              <span className="date">{chat.createDateTime}</span><br/>
                                                                              <span>{chat.message}</span>
                                                                        </div>
                                                                })
                                                        }
                                                        </div>
                                                </div>

                                                <div id="divSender">
                                                {/*닉네임 입력하여 입장하기 */}
                                                <label>닉네임</label>
                                                <input type="text" placeholder='닉네임을 입력하세요.'
                                                maxLength={7} id="sendInput" disabled={!isJoin} value={sender||''}
                                                onChange={e => setSender(e.target.value) }
                                                onKeyDown={e => {if(e.key === 'Enter'){ joinChatting(e)}}}
                                                ref={refSenderInput}
                                                />
                                                <input type="button" value="참가" id="btnJoin"  disabled={!isJoin}
                                                        onClick={(e)=>{joinChatting(e)}}/>
                                                </div>

                                                <div id="divMessage">
                                                {/**메세지 입력하기 */}    
                                                <label>메세지</label>
                                                <textarea id="messageInput" disabled={isJoin} 
                                                        value={message || ''}
                                                        onChange={e => setMessage(e.target.value)}
                                                        onKeyDown={e=> { if(e.key==='Enter'){sendMessage(e)}}}
                                                        ref={refMessageInput}>
                                                        </textarea>
                                                <input type="button" value="보내기" id="btnSend" disabled={isJoin}
                                                        onClick={e=>sendMessage(e)}/>
                                                </div>
                                        </div>
                                  </div> 
                                )
                        }
                        
                </div>

        )
}
export default Chatting