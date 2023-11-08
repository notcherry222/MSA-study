package com.example.resilience.retry_training.exception;

public class RetryException extends RuntimeException{
    public RetryException(String msg) {
        super(msg);
    }
}