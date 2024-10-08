package com.example.tobi.announcement.model;

import com.example.tobi.announcement.dto.MemberResponseDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String phone;
    private String userid;
    private String password;
    public MemberResponseDTO toMemberListResponseDTO(){
        return MemberResponseDTO.builder()
                .id(id)
                .name(name)
                .phone(phone)
                .email(userid)
                .build();
    }
}
