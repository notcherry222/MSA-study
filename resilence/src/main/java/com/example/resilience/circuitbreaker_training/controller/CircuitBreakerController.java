package com.example.resilience.circuitbreaker_training.controller;

import com.example.resilience.circuitbreaker_training.service.CircuitBreakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("circuit")
@RequiredArgsConstructor
public class CircuitBreakerController {

    private final CircuitBreakerService circuitBreakerService;

    @GetMapping("call/{param}")
    public String call(@PathVariable String param) {
        return circuitBreakerService.process(param);
    }
}
