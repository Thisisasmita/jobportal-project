package com.jobportal.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.jobportal.service.ChatLoggerService;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final ChatLoggerService chatLoggerService;

    @Autowired
public WebSocketConfig(ChatLoggerService chatLoggerService) {
    this.chatLoggerService = chatLoggerService;
}


    @Override
    public void registerStompEndpoints(@NonNull StompEndpointRegistry registry) {
        chatLoggerService.logConnection("Registering STOMP Endpoint");
        registry.addEndpoint("/ws-chat").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(@NonNull MessageBrokerRegistry registry) {
        chatLoggerService.logConnection("Configuring Message Broker");
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
