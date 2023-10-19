package com.playdata.orderservice.service;

import com.playdata.orderservice.domain.dto.request.RequestCreateDto;
import com.playdata.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public void CreateOrder(RequestCreateDto requestCreateDto) {
        orderRepository.save(requestCreateDto.toEntity());
    }
}
