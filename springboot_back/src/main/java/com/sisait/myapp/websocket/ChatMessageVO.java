package com.sisait.myapp.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageVO {
    private MessageType type;
    private String message; // 메세지
    private String sender; // 작성자
    private String createDateTime;// 날짜시간

    //채팅 목록
    private List<ChatMessageVO> history;

    public enum MessageType{
        JOIN,CHAT,LEAVE
    }
}
