package com.example.webfrontservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class RefreshTokenClientResponseDTO {
    private int status;
    private String accessToken;

    public RefreshTokenResponseDTO toRefreshTokenResponseDTO() {
        return RefreshTokenResponseDTO.builder()
                .status(status)
                .accessToken(accessToken)
                .build();
    }
}
