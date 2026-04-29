package com.sisait.myapp.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class WebsocketController {
    // 참가자 정보를 받아 접속자들에게 정보를 보낸다.
    //@Payload JSON타입의 문자열을 VO객체로 변환해주는 어노테이션.
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/chatting")
    public ChatMessageVO addUser(@Payload ChatMessageVO messageVO,
                                 SimpMessageHeaderAccessor headerAccessor){//sender, type 대입 됨
        headerAccessor.getSessionAttributes().put("sender", messageVO.getSender());
        // 메세지
        messageVO.setMessage(messageVO.getSender()+"님이 입장하였습니다.");
        // 날짜, 시간정보(2026-03-30 10:58:41)
        SimpleDateFormat fmt = new SimpleDateFormat("YYYY년 MM월 DD일 HH:mm:ss");
        messageVO.setCreateDateTime(fmt.format(new Date()));

        System.out.println(messageVO.toString());
        return messageVO;
    }
    // 채팅 메세지처리
    @MessageMapping("/chat.sendMessage")          // 글쓴이, 메세지, 채팅(CHAT)
    @SendTo("/topic/chatting")
    public ChatMessageVO sendMessage(@Payload ChatMessageVO messageVO){
        // 현재 날짜와 시간을 세팅
        SimpleDateFormat fmt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        messageVO.setCreateDateTime(fmt.format(new Date()));

        System.out.println("받은 메세지=>"+messageVO.toString());
        return messageVO;
    }
    @MessageMapping("/chat.leaveUser")
    @SendTo("/topic/chatting")
    public ChatMessageVO leaveUser(@Payload ChatMessageVO messageVO){

        messageVO.setMessage(messageVO.getSender()+"님이 퇴장하셨습니다.");
        return messageVO;

    }

}
