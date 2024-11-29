package com.example.authservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class UserLoginResponseDTO {
    private boolean loggedIn;
    private String userName;
    private String userId;
    private String accessToken;
    private String refreshToken;
}
