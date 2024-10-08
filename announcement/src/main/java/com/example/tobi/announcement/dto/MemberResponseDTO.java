package com.example.tobi.announcement.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter

@Builder
public class MemberResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;


}
