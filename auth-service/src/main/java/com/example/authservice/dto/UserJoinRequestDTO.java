package com.example.authservice.dto;

import com.example.authservice.enums.Role;
import com.example.authservice.model.User;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
public class UserJoinRequestDTO {

    private String userId;
    private String password;
    private String userName;
    private String role;

    public User toUser(BCryptPasswordEncoder bCryptPasswordEncoder) {
        return User.builder()
                .userId(userId)
                .password(bCryptPasswordEncoder.encode(password)) // 비밀번호 암호화 처리
                .userName(userName)
                .role(Role.valueOf(role))
                .build();
    }

}
