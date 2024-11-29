package com.example.authservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class UserJoinResponseDTO {
    private boolean isSuccess;
}
