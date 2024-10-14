package com.example.spring.login_whether.service;

import com.example.spring.login_whether.config.security.CustomUserDetails;
import com.example.spring.login_whether.mapper.MemberMapper;
import com.example.spring.login_whether.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberMapper.signIn(username);

        if(member == null) {
            throw new UsernameNotFoundException(username+"not found");
        }
        return CustomUserDetails.builder()
                .member(member)
                .build();
    }

}
