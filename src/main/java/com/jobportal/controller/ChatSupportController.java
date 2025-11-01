package com.jobportal.controller;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.entity.ChatSupport;

@RestController
public class ChatSupportController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/message")
    public ChatSupport sendMessage(ChatSupport message) {
        message.setTimeStamp(LocalDateTime.now());
        return message;
    }
}
