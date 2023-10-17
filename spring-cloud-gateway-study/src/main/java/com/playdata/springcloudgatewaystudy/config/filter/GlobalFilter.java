package com.playdata.springcloudgatewaystudy.config.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.GlobalConfig> {

    public GlobalFilter() { super(GlobalConfig.class);}

    @Getter
    @Setter
    public static class GlobalConfig {
        private String message;
        private boolean pre;
        private boolean post;
    }

    @Override
    public GatewayFilter apply(GlobalConfig config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            System.out.println("pre filter default message: " + config.getMessage());

            //pre에서 사용할지 말지 불린값으로 판단
            if(config.isPre()) {
                System.out.println("global pre filter: " + request.getId());
            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if(config.isPost()) {
                    System.out.println("post filter: " + response.getStatusCode());
                }
            }));
        };
    }
}
