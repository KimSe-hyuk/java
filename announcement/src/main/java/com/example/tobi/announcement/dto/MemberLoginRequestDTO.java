package com.example.tobi.announcement.dto;

import com.example.tobi.announcement.model.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberLoginRequestDTO {
    private String userid;
    private String password;
    public User toUser(){
        return User.builder()
                .userid(userid)
                .password(password)
                .build();
    }

}
