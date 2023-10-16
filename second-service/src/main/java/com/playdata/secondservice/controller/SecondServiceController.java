package com.playdata.secondservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("second-service")
public class SecondServiceController {

    private final Environment environment;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello, second service";
    }

    @RequestMapping(value = "header-check", method = RequestMethod.GET)
    public String headerCheck (@RequestHeader("secondqh") String header) {
        return header;
    }

    @GetMapping("port-check")
    public String portCheck() {
        return environment.getProperty("local.server.port");
    }
}
