package com.example.spring.springboot_basic_board2.dto;

import com.example.spring.springboot_basic_board2.model.Member;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Getter

public class SignUpRequestDTO {
    private String userName;
    private String password;
    private String userId;

    public Member toMember(BCryptPasswordEncoder bCryptPasswordEncoder) {
        return Member.builder()
                .userId(userId)
                .password(bCryptPasswordEncoder.encode(password))
                .userName(userName)
                .build();
    }
}
