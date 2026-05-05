package com.edvin.aichat.chat;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatMemoryService {

    private final Map<String, List<String>> historyBySession = new HashMap<>();

    public void addMessage(String sessionId, String role, String message) {
        historyBySession
                .computeIfAbsent(sessionId, key -> new ArrayList<>())
                .add(role + ": " + message);
    }

    public List<String> getHistory(String sessionId) {
        return historyBySession.getOrDefault(sessionId, List.of());
    }
}
