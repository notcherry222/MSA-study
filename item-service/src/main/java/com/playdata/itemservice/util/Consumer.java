package com.playdata.itemservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playdata.itemservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {

    private final ObjectMapper objectMapper;
    private final ItemService itemService;

    @RabbitListener(queues = "ITEM_CREATE_QUEUE")
    public String getTextMessage(String message) {
        System.out.println("큐에서 추출한 메시지: " + message);
        return message;
        /**
         * service에서 dto를 입력받아 db에 insert하는 로직 호출 구현해보기
         * RequestDto dto = objectMapper.
         * itemService.createItem(dto);
         */
    }
}
