package com.playdata.itemservice.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@Builder @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    Long id;
    String orderId;
    Long count;
    LocalDateTime createAt;
    String userId;
    String productId;

}