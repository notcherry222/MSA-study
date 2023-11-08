package com.example.resilience.retry_training.exception;

public class IgnoreException extends RuntimeException{
    public IgnoreException(String msg) {
        super(msg);
    }
}