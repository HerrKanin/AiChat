package com.edvin.aichat.chat;

import com.edvin.aichat.chat.dto.ChatRequest;
import com.edvin.aichat.client.OpenAiClient;
import org.springframework.stereotype.Service;


@Service
public class ChatService {

    private final PersonalityPromptService personalityPromptService;
    private final ChatMemoryService chatMemoryService;
    private final OpenAiClient openAiClient;

    public ChatService(PersonalityPromptService personalityPromptService, ChatMemoryService chatMemoryService, OpenAiClient openAiClient) {
        this.personalityPromptService = personalityPromptService;
        this.chatMemoryService = chatMemoryService;
        this.openAiClient = openAiClient;
    }

    public String process(ChatRequest request) {
        String sessionId = request.getSessionId() != null
                ? request.getSessionId()
                : "default";

        String systemPrompt = personalityPromptService.getSystemPrompt(request.getPersonality());

        chatMemoryService.addMessage(sessionId, "user", request.getMessage());

        var history = chatMemoryService.getHistory(sessionId);

        String aiResponse = openAiClient.sendMessage(systemPrompt, history, request.getMessage());

        chatMemoryService.addMessage(sessionId, "assistant", aiResponse);

        return aiResponse;
    }

}
