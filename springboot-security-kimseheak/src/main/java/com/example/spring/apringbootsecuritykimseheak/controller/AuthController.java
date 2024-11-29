package com.example.spring.apringbootsecuritykimseheak.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final HttpSession session;


    @GetMapping("/getKakaoAccessToken")
    public String getKakaoAccessToken() {
        // 세션에서 카카오 엑세스 토큰 가져오기
        return (String) session.getAttribute("kakaoAccessToken");
    }
}
