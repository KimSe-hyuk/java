package com.example.SpringBootBasicBoard.controller;

import com.example.SpringBootBasicBoard.dto.SignUpRequestDTO;
import com.example.SpringBootBasicBoard.dto.SignUpResponseDTO;
import com.example.SpringBootBasicBoard.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/join")
    public ResponseEntity<SignUpResponseDTO> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        memberService.signUp(signUpRequestDTO.toMember(bCryptPasswordEncoder));
        return ResponseEntity.ok(
                SignUpResponseDTO.builder()
                        .url("/member/login")
                        .build()
        );
    }

//    @PostMapping("/login")
//    public ResponseEntity<SignInResponseDTO> signIn(@RequestBody SignInRequestDTO signInRequestDTO, HttpSession session) {
//        return ResponseEntity.ok(
//                memberService.signIn(signInRequestDTO.toMember(), session)
//        );
//    }

}