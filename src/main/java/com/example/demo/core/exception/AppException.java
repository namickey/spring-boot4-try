package com.example.demo.core.exception;

public class AppException extends RuntimeException {

    private String messageId;
    private String field;

    public AppException(String messageId, String field, Throwable cause) {
        super(messageId, cause);
        this.messageId = messageId;
        this.field = field;
    }

    public AppException(String messageId, Throwable cause) {
        super(messageId, cause);
        this.messageId = messageId;
    }

    public AppException(String messageId, String field) {
        super(messageId);
        this.messageId = messageId;
        this.field = field;
    }

    public AppException(String messageId) {
        super(messageId);
        this.messageId = messageId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getField() {
        return this.field;
    }
}
