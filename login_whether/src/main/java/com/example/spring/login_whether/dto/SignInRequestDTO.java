package com.example.spring.login_whether.dto;

import com.example.spring.login_whether.model.Member;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
public class SignInRequestDTO {
    private String userName;
    private String password;
    private String userId;

    public Member toMember(BCryptPasswordEncoder bCryptPasswordEncoder) {
        return Member.builder()
                .userId(userId)
                .userName(userName)
                .password(bCryptPasswordEncoder.encode(password))
                .build();
    }
}
