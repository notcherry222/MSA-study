package com.playdata.feignclient;


import jakarta.persistence.criteria.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient (name = "ORDER-SERVICE", path = "order-service")
public interface OrderFeignClient extends JpaRepository<Order, Long> {
    @GetMapping("/oders/{userId}")
    public List<Order> getOrderByUserId(@PathVariable String userId);
}
