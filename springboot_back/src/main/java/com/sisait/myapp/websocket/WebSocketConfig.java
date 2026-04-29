package com.sisait.myapp.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// 환경설정 파일
@Configuration
@EnableWebSocketMessageBroker // websocket메세지 처리를 활설화 시킨다.
public class WebSocketConfig  implements WebSocketMessageBrokerConfigurer {

    // 채팅하기 위한 접속
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }

    // 메세지를 주고받을 브로커 접두어
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        // 서버에서 /app 으로 접속하면 메세지 처리하는 설정
        registry.setApplicationDestinationPrefixes("/app");
        // 서버가 클라이언트에게 메세지를 보낼때 사용할 브로커
        registry.enableSimpleBroker("/topic");
    }
}
