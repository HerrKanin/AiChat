package com.edvin.aichat.chat.dto;

import jakarta.validation.constraints.NotBlank;

public class ChatRequest {

    @NotBlank(message = "Personality is required")
    private String personality;
    @NotBlank(message = "Message is required")
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
