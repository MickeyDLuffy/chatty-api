package com.github.mickeydeeluffy.chattyapi.service.impl;

import com.github.mickeydeeluffy.chattyapi.entity.ChatMessage;
import com.github.mickeydeeluffy.chattyapi.service.WebsocketService;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class WebsocketServiceImpl implements WebsocketService {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebsocketServiceImpl(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }
    @MessageMapping("/secured/room")
    public void sendChatToUser(@Payload ChatMessage chatMessage, Principal chatter, @Header("simpSessionId") String sessionId) {
        ChatMessage chatMessage1 = ChatMessage.builder().message("Sending a message from backend").sender("dluffy").build();
        simpMessagingTemplate.convertAndSendToUser("mickey", "/secured/user/queue/user-id", chatMessage1);

    }
}
