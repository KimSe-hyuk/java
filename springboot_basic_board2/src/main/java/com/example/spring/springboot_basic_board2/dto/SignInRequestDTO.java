package com.example.spring.springboot_basic_board2.dto;

import com.example.spring.springboot_basic_board2.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class SignInRequestDTO {
    private String password;
    private String userId;


}
