package com.playdata.springcloudgatewaystudy.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    //yml 파일에 있는 path 경로를 필터를 이용해 config class에서 구현하기
    //@Bean
    public RouteLocator gatewayLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes() // 라우팅 정보 등록 시작 지점
                .route(r -> r.path("/first-service/**")
                            .filters(f -> f.addRequestHeader("firstqh","firstqhv")
                                    .addResponseHeader("firstrh","firstrhv"))
                            .uri("http://localhost:8001/")
                )// 개별 라우팅 정보를 등록하는 route 메서드, 8000으로 들어 가야만 추가된 헤더 확인 가능.
                .route(r -> r.path("/second-service/**")
                            .filters(f -> f.addRequestHeader("secondqh", "secondqhv")
                                .addResponseHeader("secondrh", "secondrhv"))
                            .uri("http://localhost:8002/"))
                .build(); // 라우팅 정보 등록 종료 시점
    }
}
