package com.example.spring.springboot_basic_board2.dto;

import com.example.spring.springboot_basic_board2.enums.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResponseDTO {
    private long id;
    private String userId;
    private String userName;
    private Role role;
}
