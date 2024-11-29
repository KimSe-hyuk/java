package com.example.authservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UserLoginRequestDTO {
    private String userId;
    private String password;
}
