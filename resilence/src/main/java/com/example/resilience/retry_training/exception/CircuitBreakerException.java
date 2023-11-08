package com.example.resilience.retry_training.exception;

public class CircuitBreakerException extends RuntimeException{

    public CircuitBreakerException(String msg) {
        super(msg);
    }
}
