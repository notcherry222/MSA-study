package com.playdata.orderservice.controller;

import com.playdata.orderservice.domain.dto.request.RequestCreateDto;
import com.playdata.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor
@RequestMapping("order-service")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("health-check")
    public String healthCheck() {
        return "order-service is available";
    }

    @PostMapping("orders")
    public ResponseEntity<?> createOrder(@RequestBody RequestCreateDto requestCreateDto) {
        orderService.CreateOrder(requestCreateDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
