package com.example.demo.exception;

public class CustomerNotFoundException extends RuntimeException{
    private String message;

    public CustomerNotFoundException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String toString() {
        return "CustomerNotFoundException{" +
                "message='" + message + '\'' +
                '}';
    }
}
