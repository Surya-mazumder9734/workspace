package com.example.demo.exception;

public class EmailNotFoundException extends IllegalArgumentException{
    private String message;

    public EmailNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
