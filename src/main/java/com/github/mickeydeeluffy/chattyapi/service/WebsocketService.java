package com.github.mickeydeeluffy.chattyapi.service;

import com.github.mickeydeeluffy.chattyapi.entity.ChatMessage;

import java.security.Principal;

public interface WebsocketService {

     void sendChatToUser( ChatMessage chatMessage, Principal chatter,String sessionId);
}
