package com.edvin.aichat.client;

import com.edvin.aichat.config.OpenAiConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OpenAiClient {

    private final RestClient restClient;
    private final OpenAiConfig openAiConfig;

    public OpenAiClient(OpenAiConfig openAiConfig) {
        this.openAiConfig = openAiConfig;
        this.restClient = RestClient.builder()
                .baseUrl(openAiConfig.getBaseUrl())
                .defaultHeader("Authorization", "Bearer " + openAiConfig.getApiKey())
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public String sendMessage(String systemPrompt, List<String> history, String userMessage) {
        List<Map<String, String>> messages = new ArrayList<>();

        messages.add(Map.of("role", "system", "content", systemPrompt));

        for (String historyMessage : history) {
            if (historyMessage.startsWith("user: ")) {
                messages.add(Map.of("role", "user", "content", historyMessage.substring(6)));
            } else if (historyMessage.startsWith("assistant: ")) {
                messages.add(Map.of("role", "assistant", "content", historyMessage.substring(11)));
            }
        }

        Map<String, Object> requestBody = Map.of(
                "model", openAiConfig.getModel(),
                "messages", messages
        );

        Map response =  restClient.post()
                .uri("/chat/completions")
                .body(requestBody)
                .retrieve()
                .body(Map.class);

        List<Map> choices = (List<Map>) response.get("choices");
        Map message = (Map) choices.get(0).get("message");

        return message.get("content").toString();
    }
}
