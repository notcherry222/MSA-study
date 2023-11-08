package com.playdata.itemservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.playdata.itemservice.dto.request.RequestCreateItemDto;
import com.playdata.itemservice.dto.response.ResponseOrderByItemDto;
import com.playdata.itemservice.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ItemController {

    private ItemService itemService;

    @GetMapping("itmes/{productId}/orders")
    public ResponseEntity<?> GetOrderByProductId(@PathVariable String productId) {
        ResponseOrderByItemDto dto = itemService.
    }

    @GetMapping("health-check")
    public String healthCheck() {
        return "item-service service is avaliable.";
    }

    @PostMapping("items")
    public ResponseEntity<?> createItemm(@Valid @RequestBody RequestCreateItemDto dto)
    throws JsonProcessingException {
        itemService.publishCreateItemMessage(dto);
        return ResponseEntity.ok("메시지큐에 생성 요청 적재 완료");
    }
}
