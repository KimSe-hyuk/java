package com.example.tobi.announcement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RedirectResponseDTO {
    private String redirectUrl;
    private boolean success;
}
