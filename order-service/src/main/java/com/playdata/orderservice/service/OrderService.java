package com.playdata.orderservice.service;

import com.playdata.orderservice.domain.dto.request.RequestCreateDto;
import com.playdata.orderservice.repository.OrderRepository;
import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public void CreateOrder(RequestCreateDto requestCreateDto) {
        orderRepository.save(requestCreateDto.toEntity());
    }

    public Optional<List<Order>> getOrderListByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
