package com.playdata.itemservice.feignclient;

import com.playdata.itemservice.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ORDER-SERVICE", path = "order-service")
public interface OrderFeignClient { // order service 로 요청할 예정
    @GetMapping("/orders/{itemId}/items")
    public List<Order> getOrderByItemId(@PathVariable String itemId);
}
