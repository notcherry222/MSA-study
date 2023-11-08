package com.playdata.itemservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playdata.itemservice.dto.request.RequestCreateItemDto;
import com.playdata.itemservice.repository.ItemRepository;
import com.playdata.itemservice.util.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final Producer producer;
    private final ObjectMapper objectMapper;

    public void publishTestMessage(String message) { producer.sendTestMessage(message);}

    public void publishCreateItemMessage(RequestCreateItemDto dto)
            throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(dto);
        producer.sendCreateItemMessage(message);
    }
}
