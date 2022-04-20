package com.github.mickeydeeluffy.chattyapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
//        registry.enableSimpleBroker("/secured/user/queue/user-id");
//        registry.setApplicationDestinationPrefixes("/chat-api");
//        registry.setUserDestinationPrefix("/secured/user");
        config.enableSimpleBroker("/chat");
        config.setApplicationDestinationPrefixes("/app");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/secured/room").setAllowedOrigins("*").withSockJS();
    }
}
