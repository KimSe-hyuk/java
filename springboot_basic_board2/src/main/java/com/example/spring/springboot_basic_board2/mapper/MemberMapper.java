package com.example.spring.springboot_basic_board2.mapper;

import com.example.spring.springboot_basic_board2.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void signUp(Member member);

    Member findByUserId(String userId);
}
