package com.playdata.springcloudgatewaystudy.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LogFilter extends AbstractGatewayFilterFactory<LogFilter.Config> {
    // 응집도를 높이기 위해 사용하는 클래스 내에 설정
    public static class Config {}
    public LogFilter() {
        super(Config.class);
    }


    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest(); // netty에서는 serverHttpRequest사용
            ServerHttpResponse response = exchange.getResponse(); // import 주의!

            log.info("log pre filter : {}", request.getId());

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("log post filter : {}", response.getStatusCode());
            }));
        };
    }
}
