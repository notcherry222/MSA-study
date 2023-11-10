package com.playdata.domain.dto.request;

import com.playdata.domain.User;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Builder
public class RequestCreateUserDto {

    @Email
    private String email;
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하입니다.")
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String userId;

    public User toEntity() {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return User.builder()
                .email(this.email)
                .encPw(bCryptPasswordEncoder.encode(this.password)) //encoding된 password를 넣어야 함
                .name(this.name)
                .userId(this.userId)
                .uuid(UUID.randomUUID().toString())
                .createAt(LocalDateTime.now())
                .build();
    }
}
