package com.example.SpringBootBasicBoard.controller;

import com.example.SpringBootBasicBoard.dto.SignInResponseDTO;
import com.example.SpringBootBasicBoard.dto.SignInRequestDTO;
import com.example.SpringBootBasicBoard.dto.SignUpRequestDTO;
import com.example.SpringBootBasicBoard.dto.SignUpResponseDTO;
import com.example.SpringBootBasicBoard.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<SignUpResponseDTO> signUp(@RequestBody SignUpRequestDTO requestDTO) {
        memberService.signUp(requestDTO.toMember());
        return ResponseEntity.ok(SignUpResponseDTO.builder().url("/member/login").build());
    }
    @PostMapping("/login")
    public ResponseEntity<SignInResponseDTO> signUp(@RequestBody SignInRequestDTO requestDTO, HttpSession session) {

        return ResponseEntity.ok(
                memberService.signIn(requestDTO.toMember(),session)
        );
    }

}