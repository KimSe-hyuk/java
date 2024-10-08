package com.example.tobi.announcement.dto;
import com.example.tobi.announcement.model.User;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class MemberCreateRequestDTO {
    private Long id;
    private String name;
    private String phone;
    private String userid;
    private String password;
    public User toUser(){
        return User.builder()
                .id(id)
                .name(name)
                .phone(phone)
                .userid(userid)
                .password(password)
                .build();
    }
}