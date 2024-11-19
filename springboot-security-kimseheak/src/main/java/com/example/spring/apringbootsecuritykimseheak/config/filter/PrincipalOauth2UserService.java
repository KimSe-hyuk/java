package com.example.spring.apringbootsecuritykimseheak.config.filter;//package com.example.spring.apringbootsecuritykimseheak.config.filter;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.*;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
/*

@Service
public class PrincipalOauth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2AccessToken accessToken = userRequest.getAccessToken();
        String userInfoUri = "https://www.googleapis.com/oauth2/v3/userinfo"; // 구글 사용자 정보 API

        // 구글 API로 사용자 정보 요청
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken.getTokenValue()); // Bearer Token 설정

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(userInfoUri, HttpMethod.GET, entity, Map.class);

        // 구글 사용자 정보 추출
        Map<String, Object> userAttributes = response.getBody();

        // OAuth2User 객체를 반환
        assert userAttributes != null;
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")), // 권한 설정
                userAttributes, // 사용자 정보 (구글에서 가져온 정보)
                "name" // 인증된 사용자 ID 필드 (예: "name", "email")
        );
          }

}
*/

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static com.mysql.cj.conf.PropertyKey.logger;

@RequiredArgsConstructor
@Service
@Slf4j
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private final HttpSession session;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // 기본적으로 OAuth2User를 로드
        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println("oAuth2User 입니다 : " + oAuth2User.getAttributes());

        // 로그인 제공자 식별 (구글 또는 카카오)
        String provider = userRequest.getClientRegistration().getRegistrationId(); // 구글 또는 카카오
        System.out.println("로그인 제공자" + provider);

        // 고유 사용자 ID를 얻기 위한 필드 이름 (구글: "sub", 카카오: "id")
        String id = null;

        // OAuth2User의 기존 속성을 수정하려면 Map을 가져옴
        Map<String, Object> attributes = new HashMap<>(oAuth2User.getAttributes());

        if ("google".equals(provider)) {
            // Google 로그인 처리: "sub" 필드에서 사용자 ID 추출
            Object googleId = oAuth2User.getAttributes().get("sub"); // 구글에서 받은 "sub" 필드 (사용자 ID)

            if (googleId instanceof Long) {
                id = String.valueOf(googleId);  // Long을 String으로 변환
            } else if (googleId instanceof String) {
                id = (String) googleId;  // 이미 String이면 그대로 사용
            }

            attributes.put("id", id); // "id"로 변경하여 attributes에 추가
            attributes.remove("sub"); // 기존의 "sub" 필드를 삭제
        } else if ("kakao".equals(provider)) {
            // Kakao 로그인 처리: "id" 필드에서 사용자 ID 추출
            Object kakaoId = oAuth2User.getAttributes().get("id"); // 카카오에서 받은 "id" 필드 (사용자 ID)

            if (kakaoId instanceof Long) {
                id = String.valueOf(kakaoId);  // Long을 String으로 변환
            } else if (kakaoId instanceof String) {
                id = (String) kakaoId;  // 이미 String이면 그대로 사용
            }

            attributes.put("id", id); // "id"로 변경하여 attributes에 추가

            // 카카오 로그인 시 AccessToken을 세션에 저장
            String kakaoAccessToken = userRequest.getAccessToken().getTokenValue();
            session.setAttribute("kakaoAccessToken", kakaoAccessToken);
        }

        System.out.println("id입니다. "+ id);
        // 최종적으로 OAuth2User 객체를 반환 (수정된 attributes 사용)
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")), // 권한 설정
                attributes, // 수정된 사용자 정보
                "id" // 'id'를 사용자 정보에서 이름을 나타내는 속성으로 사용
        );
    }

}
