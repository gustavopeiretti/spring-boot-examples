package com.gustavopeiretti.springbootadvice.exception;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }
}
