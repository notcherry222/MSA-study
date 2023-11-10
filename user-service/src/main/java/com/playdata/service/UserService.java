package com.playdata.service;

import com.playdata.domain.User;
import com.playdata.domain.dto.request.RequestCreateUserDto;
import com.playdata.domain.dto.response.ResponseFindUserDto;
import com.playdata.exception.UserNotFoundException;
import com.playdata.feignclient.OrderFeignClient;
import com.playdata.repository.UserRepository;
import jakarta.persistence.criteria.Order;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final OrderFeignClient orderFeignClient;

    public void createUser(RequestCreateUserDto userDto) {
        //dto를 entity로 변경
        User user = userDto.toEntity();
        userRepository.save(user);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public ResponseFindUserDto findUserByUuid(String uuid) {
        User user = userRepository.findUserByUuid(uuid);

        if(user == null) {
            throw new UserNotFoundException("해당 유저는 존재하지 않습니다.");
        }
        return new ResponseFindUserDto(user);
    }

    public ResponseFindUserDto findUserOrderList(String userId) {
        User user = userRepository.findUserByUserId(userId);
        ResponseFindUserDto userDto = new ResponseFindUserDto(user);

        List<Order> orderList = orderFeignClient.getOrderByUserId(userId);
        userDto.setOrderList(orderList);
        return userDto;
    }
}