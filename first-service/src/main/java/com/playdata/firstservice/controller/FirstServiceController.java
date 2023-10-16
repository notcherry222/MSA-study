package com.playdata.firstservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("first-service")
public class FirstServiceController {
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello, first service";
    }
    @GetMapping("header-check")
    public String headerCheck(@RequestHeader("firstqh") String header) { //firstrh라는 변수를 header로 바인딩하겠다!
        return header;
    }
}
