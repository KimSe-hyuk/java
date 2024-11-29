package com.example.webfrontservice.service;

import com.example.webfrontservice.client.AuthClient;
import com.example.webfrontservice.dto.RefreshTokenClientResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final AuthClient authClient;

    public RefreshTokenClientResponseDTO refreshToken() {
        return authClient.refresh();
    }
}
