package com.example.tobi.springbootbasic.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDeleteUserResponsDTO {

    private String password;
    private Long id;
    private String userid;


}