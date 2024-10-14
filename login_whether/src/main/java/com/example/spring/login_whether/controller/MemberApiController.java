package com.example.spring.login_whether.controller;

import com.example.spring.login_whether.dto.SignInRequestDTO;
import com.example.spring.login_whether.dto.SignUpResponseDTO;
import com.example.spring.login_whether.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/join")
    public ResponseEntity<SignUpResponseDTO> join(@RequestBody SignInRequestDTO requestDTO) {
        memberService.signUp(requestDTO.toMember(bCryptPasswordEncoder));
        return  ResponseEntity.ok(
                SignUpResponseDTO.builder()
                        .url("/member/login")
                        .build()
        );
    }
}
