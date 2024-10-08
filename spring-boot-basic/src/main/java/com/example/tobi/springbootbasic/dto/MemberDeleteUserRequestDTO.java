package com.example.tobi.springbootbasic.dto;

import com.example.tobi.springbootbasic.model.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDeleteUserRequestDTO {

    private String password;
    private Long id;
    private String userid;

    public User toUser(){
        return User.builder()
                .id(id)
                .userid(userid)
                .password(password)
                .build();
    }
}