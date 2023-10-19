package com.playdata.orderservice.domain.dto.request;

import com.playdata.orderservice.domain.Order;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter @Validated
@Builder @ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateDto {
    private Long id;
    private String orderId;
    private Long count;
    private LocalDateTime createAt;
    private String userId;
    private String productId;

    public Order toEntity() {
        return Order.builder()
                .orderId(UUID.randomUUID().toString())
                .orderId(this.orderId)
                .count(this.count)
                .createAt(LocalDateTime.now())
                .userId(this.userId)
                .productId(this.productId)
                .build();
    }
}
