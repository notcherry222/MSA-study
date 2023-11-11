package com.playdata.itemservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playdata.itemservice.domain.Item;
import com.playdata.itemservice.domain.Order;
import com.playdata.itemservice.dto.request.RequestCreateItemDto;
import com.playdata.itemservice.dto.response.ResponseOrderByItemDto;
import com.playdata.itemservice.feignclient.OrderFeignClient;
import com.playdata.itemservice.repository.ItemRepository;
import com.playdata.itemservice.util.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final OrderFeignClient orderFeignClient;

    public void createItem(RequestCreateItemDto dto) {
        itemRepository.save(dto.toEntity());
    }

    public ResponseOrderByItemDto findOrderByItem(String productId) {
        Item item = itemRepository.findItemByProductId(productId)
                .orElseThrow(() -> new RuntimeException("해당 아이템은 없습니다"));

        ResponseOrderByItemDto itemDto = new ResponseOrderByItemDto(item);

        List<Order> orderList = orderFeignClient.getOrderByItemId(productId);
        itemDto.setOrderList(orderList);

        return itemDto;
    }
}
