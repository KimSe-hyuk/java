package com.example.SpringBootBasicBoard.mapper;

import com.example.SpringBootBasicBoard.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void signUp(Member member);

    Member signIn(String userId);
}
