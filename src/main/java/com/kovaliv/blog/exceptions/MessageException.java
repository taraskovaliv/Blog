package com.kovaliv.blog.exceptions;

public class MessageException extends Exception {
    private String message;

    public MessageException(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
