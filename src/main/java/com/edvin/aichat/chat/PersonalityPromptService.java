package com.edvin.aichat.chat;

import org.springframework.stereotype.Service;

@Service
public class PersonalityPromptService {

    public String getSystemPrompt(String personality) {
        if (personality == null) {
            return helperPrompt();
        }

        return switch (personality.toLowerCase()) {
            case "coder" -> "You are helpful coding assistant. Explain programming concepts with examplet.";
            case "pirate" -> "You are a pirate. Answer in a playful style.";
            case "helper" -> helperPrompt();
            default -> helperPrompt();
        };
    }

    private String helperPrompt(){
        return "You are a helpful assistant. Answer clearly and politely";
    }
}
