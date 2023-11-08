package com.example.resilience.retry_training.service;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

@Service
public class RetryService {
    //retry와 관련된 config file name 저장 상수
    private static final String CONFIG_CLASS_NAME = "retryConfig";

    //@Retry를 붙이면 재시도를 해주는 직접적인 메소드
    //재시도를 구체적으로 어떻게 할 지는 CONFIG_CLASS_NAME에 적힌 CONFIG 클래스로 등록된 빈을 통해 설정
    //fallback 메서드에 적은 메서드가 바로 재시도를 했는데도 문제가 되면 호출해 줄 메서드의 시그니처 등록
    @Retry(name = CONFIG_CLASS_NAME, fallbackMethod = "fallback")
    public String process(String param) {
        return callAnotherServer(param);
    }

    private String fallback(String param, Exception e) {
        //retry에서 지정한 실패 횟수를 모두 채우면 fallback 호출
        System.out.println(param + "요청 처리를 시도할 수 없습니다.");
        return "처리됨: " + e.toString();
    }

    private String callAnotherServer(String param) {
        //retry exception은 retry 된다.
        throw new RuntimeException("예외 발생");

        //ignore exception은 rety 안 한다
        //throw new IgnoreException("");
    }
}