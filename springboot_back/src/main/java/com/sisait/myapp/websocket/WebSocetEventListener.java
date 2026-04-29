package com.sisait.myapp.websocket;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocetEventListener {
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){

        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String sender =(String) headerAccessor.getSessionAttributes().get("sender");

        if(sender != null){
            System.out.println(sender+"님 연결 종료.............");
        }
    }

}
