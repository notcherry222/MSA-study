package com.playdata.orderservice.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter @Builder @Entity
@AllArgsConstructor @NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // todo: UUID 인 경우와 차이점?
    Long id;
    @Column(updatable = false) //주문 코드 불변. 최초의 것 적음.
    String orderId;
    Long count;
    @CreatedDate @Column(updatable = false)  //가입 시간 불변
    LocalDateTime createAt;
    String userId;
    String productId;
}