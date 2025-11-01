package com.jobportal.service;


import org.springframework.stereotype.Service;

@Service
public class ChatLoggerService {
    public void logConnection(String message) {
        System.out.println("WebSocket Log: " + message);
    }
}
