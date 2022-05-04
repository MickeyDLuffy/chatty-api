package com.github.mickeydeeluffy.chattyapi.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

@Jacksonized
@Value
@Builder(toBuilder = true)
public class ChatMessage {
     UUID id;
     String message;
     String sender;
}
