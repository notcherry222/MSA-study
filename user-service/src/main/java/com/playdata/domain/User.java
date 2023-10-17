package com.playdata.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity @Getter @Table(name = "users")
@AllArgsConstructor @NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String userId;
    private String encPw;
    private String uuid; //회원가입시 회원에게 따로 값을 배정. 중복 없는 값임
    private LocalDateTime createAt;
}
