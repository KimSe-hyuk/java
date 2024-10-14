package com.example.spring.login_whether.service;

import com.example.spring.login_whether.mapper.MemberMapper;
import com.example.spring.login_whether.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    public void signUp(Member member) {
        memberMapper.signUp(member);
    }
}
