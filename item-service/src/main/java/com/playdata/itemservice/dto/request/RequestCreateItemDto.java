package com.playdata.itemservice.dto.request;

import com.playdata.itemservice.domain.Item;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class RequestCreateItemDto {

    @Pattern(regexp="^[a-zA-Z가-힣0-9]+")
    @NotNull(message = "상품명은 반드시 입력 받아야 한다.")
    private String productName;
    private Long stock;
    private Long pricePerItem;

    public Item toEntity() {
        return Item.builder()
                .productId(UUID.randomUUID().toString())
                .stock(this.stock)
                .productName(this.productName)
                .pricePerItem(this.pricePerItem)
                .build();
    }
}
