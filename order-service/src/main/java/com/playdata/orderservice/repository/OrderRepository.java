package com.playdata.orderservice.repository;

import com.playdata.orderservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional findByUserId(String userId);
}
