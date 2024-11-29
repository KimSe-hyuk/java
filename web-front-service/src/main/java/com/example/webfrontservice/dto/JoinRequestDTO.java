package com.example.webfrontservice.dto;

import com.example.webfrontservice.enums.Role;
import lombok.Getter;

@Getter
public class JoinRequestDTO {
    private String userId;
    private String userName;
    private String password;
    private Role role;
}
