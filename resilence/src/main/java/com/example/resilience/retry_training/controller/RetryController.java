package com.example.resilience.retry_training.controller;

import com.example.resilience.retry_training.service.RetryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("retry")
@RequiredArgsConstructor
public class RetryController {

    private final RetryService retryService;

    @GetMapping("call/{param}")
    public String call(@PathVariable String param) {
        return retryService.process(param);
    }

}
