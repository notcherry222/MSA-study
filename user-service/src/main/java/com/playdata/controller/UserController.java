package com.playdata.controller;

import com.playdata.domain.User;
import com.playdata.domain.dto.request.RequestCreateUserDto;
import com.playdata.domain.dto.response.ResponseFindUserDto;
import com.playdata.service.UserService;
import jakarta.validation.Valid;
import jakarta.ws.rs.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user-service")
public class UserController {

    private final UserService userService;

    @RequestMapping("health-check")
    public String healthCheck() {
        return "server is available";
    }

    @RequestMapping("health-check2")
    public String healthCheck2() {
        return "server is available-2";
    }

    @PostMapping("users")
    public ResponseEntity<String> createUser(@Valid @RequestBody RequestCreateUserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok( "join complete");
    }

    //가입된 계정을 uuid기반으로 찾아오기
    @GetMapping("users/{uuId}")
    public ResponseEntity<?> findUserByUuId(@PathVariable String uuId) {
        ResponseFindUserDto responseDto= userService.findUserByUuid(uuId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<?> findOrderByUserId(@PathVariable String userId) {
        ResponseFindUserDto dto =userService.findUserOrderList(userId);
        return ResponseEntity.ok(dto);
    }
}
