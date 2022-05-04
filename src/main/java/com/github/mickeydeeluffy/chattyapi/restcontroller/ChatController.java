package com.github.mickeydeeluffy.chattyapi.restcontroller;

import com.github.mickeydeeluffy.chattyapi.entity.ChatMessage;
import com.github.mickeydeeluffy.chattyapi.service.WebsocketService;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;

@RestController

//@RequestMapping("/api/v1/message")
@Slf4j
public class ChatController {

    private final WebsocketService  websocketService;
    public ChatController(SimpMessagingTemplate simpMessagingTemplate, WebsocketService websocketService) {
        this.websocketService = websocketService;
        var d = new ArrayList<>();
    }

    @MessageMapping("/secured/room")
    public void sendChatToUser(@Payload String chatMessage, Principal chatter, @Header("simpSessionId") String sessionId) {
        log.info("Inside secured roooom {}", chatMessage);
//        websocketService.sendChatToUser(chatMessage, chatter, sessionId);
    }

}
