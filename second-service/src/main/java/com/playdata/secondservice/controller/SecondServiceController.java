package com.playdata.secondservice.controller;


import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("second-service")
public class SecondServiceController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello, second service";
    }

    @RequestMapping(value = "header-check", method = RequestMethod.GET)
    public String headerCheck (@RequestHeader("secondqh") String header) {
        return header;
    }
}
