package com.playdata.springcloudgatewaystudy.config.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomFilter2 extends AbstractGatewayFilterFactory<CustomFilter2.Config2> {
    public static class Config2 {}

    public CustomFilter2() {
        super(Config2.class);
    }

    @Override
    public GatewayFilter apply(Config2 config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            //pre filter -> 클래스 내부에 실행문으로 작성하면 작동한다.
            System.out.println("Custom2 pre filter: " + request.getId());

            //post filter -> return 구문 속에 코드를 작성해야 작동한다.
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("Custom2 post filter: "+ response.getStatusCode());
            }));
        };
    }
}
