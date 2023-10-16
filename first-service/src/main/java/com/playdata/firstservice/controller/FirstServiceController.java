package com.playdata.firstservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("first-service")
@RequiredArgsConstructor
public class FirstServiceController {
    private final Environment environment;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello, first service";
    }

    @GetMapping("header-check")
    public String headerCheck(@RequestHeader("firstqh") String header) { //firstrh라는 변수를 header로 바인딩하겠다!
        return header;
    }

    //0으로 포트 번호 랜덤 할당한 후 포트번호 확인하는 컨트롤러
    @GetMapping("port-check")
    public String portCheck() {
        return environment.getProperty("local.server.port");
    }
}
