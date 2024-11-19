package com.example.spring.springboot_basic_board2.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LogoutResponseDTO {
    private String url;
    private String message;
}
