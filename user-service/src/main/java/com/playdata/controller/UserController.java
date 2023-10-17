package com.playdata.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-service")
public class UserController {

    @RequestMapping("health-check")
    public String healthCheck() {
        return "server is available";
    }
}
