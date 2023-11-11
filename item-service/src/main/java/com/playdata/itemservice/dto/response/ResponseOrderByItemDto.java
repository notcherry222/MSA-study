package com.playdata.itemservice.dto.response;

import com.playdata.itemservice.domain.Item;
import com.playdata.itemservice.domain.Order;
import lombok.*;

import java.util.List;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
public class ResponseOrderByItemDto {
    private Long id;
    private String productId;
    private String productName;
    private Long stock;
    private Long pricePerItem;
    private List<Order> orderList;

    public ResponseOrderByItemDto(Item item) {
        this.id = item.getId();
        this.productId = item.getProductId();
        this.productName = item.getProductName();
        this.stock = item.getStock();
        this.pricePerItem = item.getPricePerItem();
    }
}
