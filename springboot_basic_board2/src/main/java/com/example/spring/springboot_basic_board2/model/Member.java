package com.example.spring.springboot_basic_board2.model;

import com.example.spring.springboot_basic_board2.enums.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class Member {
    private long id;
    private String userId;
    private String password;
    private String userName;
    private Role role;
}
