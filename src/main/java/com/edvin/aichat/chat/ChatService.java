package com.edvin.aichat.chat;

import com.edvin.aichat.chat.dto.ChatRequest;
import com.edvin.aichat.chat.dto.ChatResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final PersonalityPromptService personalityPromptService;
    private final ChatMemoryService chatMemoryService;

    public ChatService(PersonalityPromptService personalityPromptService, ChatMemoryService chatMemoryService) {
        this.personalityPromptService = personalityPromptService;
        this.chatMemoryService = chatMemoryService;
    }

    public String process(ChatRequest request) {

        String sessionId = request.getSessionId() != null
                ? request.getSessionId()
                : "default";

        String systemPrompt = personalityPromptService.getSystemPrompt(request.getPersonality());

        chatMemoryService.addMessage(sessionId, "user", request.getMessage());

        List<String> history = chatMemoryService.getHistory(sessionId);

        String response = "System: " + systemPrompt + "\nHistory: " + history;

        chatMemoryService.addMessage(sessionId, "assistant", response);

        return response;
    }

}
