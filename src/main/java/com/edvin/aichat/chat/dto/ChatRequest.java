package com.edvin.aichat.chat.dto;

public class ChatRequest {

    private String personality;
    private String message;
    private String sessionId;

    public String getPersonality() {
        return personality;
    }

    public String getMessage() {
        return message;
    }

    public String getSessionId() {
        return sessionId;
    }
}
