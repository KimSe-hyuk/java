package com.example.SpringBootBasicBoard.dto;

import com.example.SpringBootBasicBoard.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class SignInRequestDTO {
    private String password;
    private String userId;

    public Member toMember() {
        return Member.builder()
                .userId(userId)
                .password(password)
                .build();
    }
}
