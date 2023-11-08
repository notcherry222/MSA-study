package com.playdata.itemservice.util;

import org.springframework.stereotype.Component;

@Component
public class Producer {

    public String message;

    public String sendTestMessage(String message) {
        return message;
    }

    public String sendCreateItemMessage(String message) {
        return this.message;
    }
}
