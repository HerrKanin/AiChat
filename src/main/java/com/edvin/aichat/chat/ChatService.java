package com.edvin.aichat.chat;

import com.edvin.aichat.chat.dto.ChatRequest;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public String process(ChatRequest request) {
        return "Du skrev: " + request.getMessage();
    }
}
