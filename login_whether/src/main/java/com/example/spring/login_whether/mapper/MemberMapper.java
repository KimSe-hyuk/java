package com.example.spring.login_whether.mapper;

import com.example.spring.login_whether.model.Member;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
    void signUp(Member member);

    Member signIn(String userId);
}
