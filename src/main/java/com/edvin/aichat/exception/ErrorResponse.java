package com.edvin.aichat.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

    private final LocalDateTime timeStamp;
    private final int status;
    private final String message;

    public ErrorResponse(int status, String message) {
        this.timeStamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
