package com.playdata.itemservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.playdata.itemservice.dto.request.RequestCreateItemDto;
import com.playdata.itemservice.dto.response.ResponseOrderByItemDto;
import com.playdata.itemservice.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("item-service")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("health-check")
    public String healthCheck() {
        return "Item-service service is available";
    }

    @PostMapping("items")
    public ResponseEntity<?> createItem(@RequestBody RequestCreateItemDto dto) {
        itemService.createItem(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
