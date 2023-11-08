package com.example.resilience.circuitbreaker_training.service;

import com.example.resilience.retry_training.exception.IgnoreException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class CircuitBreakerService {
    private static final String CIRCUITBREAKER_CONFIG = "circuitBreakerConfig";

    @CircuitBreaker(name = CIRCUITBREAKER_CONFIG, fallbackMethod = "fallback")
    public String process(String param) {
        return callFeignClient(param);
    }

    private String fallback(String param, Exception e) {
        //circuit breaker의 fallback은 IgnoreException에 의해서도 실행된다.
        //다만 ignoreException에 등록된 유형의 예외를 통해서는 open  상태로의 전환은 이루어지지 않는다.
        System.out.println(param + "파라미터에 의해 에러가 발생했습니다.");
        return "예외 종류: " + e.toString();
    }

    private String callFeignClient(String param) {
        if("a".equals(param)) {
            throw new RuntimeException("A 유형 예외 발생");
        } else if("b".equals(param)) {
            throw new IgnoreException("B 유형 예외 발생");
        }

        return param;
    }
}
