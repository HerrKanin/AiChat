package com.edvin.aichat.chat;

import com.edvin.aichat.chat.dto.ChatRequest;
import com.edvin.aichat.chat.dto.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final PersonalityPromptService personalityPromptService;

    public ChatService(PersonalityPromptService personalityPromptService) {
        this.personalityPromptService = personalityPromptService;
    }

    public String process(ChatRequest request) {
        String systemPrompt = personalityPromptService.getSystemPrompt(request.getPersonality());

        return "Personality prompt:" + systemPrompt + "\nDu skrev: " + request.getMessage();
    }

}
