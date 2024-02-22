package com.gustavopeiretti.springbootadvice.exception;

public class DataIntegrityViolationException extends RuntimeException {

    public DataIntegrityViolationException(String message) {
        super(message);
    }

}
