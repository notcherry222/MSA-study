package com.playdata.domain.dto.response;

import com.playdata.domain.User;
import lombok.*;


@Getter @Setter @Builder @ToString
@AllArgsConstructor @NoArgsConstructor
public class ResponseFindUserDto {
    private Long id;
    private String email;
    private String name;
    private String userId;

    public ResponseFindUserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.userId = user.getUserId();
    }
}
