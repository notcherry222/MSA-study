package com.playdata.service;

import com.playdata.domain.User;
import com.playdata.domain.dto.request.RequestCreateUserDto;
import com.playdata.domain.dto.response.ResponseFindUserDto;
import com.playdata.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(RequestCreateUserDto userDto) {
        //dto를 entity로 변경
        User user = userDto.toEntity();
        userRepository.save(user);
    }

    public ResponseFindUserDto findUserByUuid(String uuid) {
        return new ResponseFindUserDto(userRepository.findUserByUuid(uuid));
    }
}