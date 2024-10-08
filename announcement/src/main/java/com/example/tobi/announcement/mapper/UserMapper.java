package com.example.tobi.announcement.mapper;

import com.example.tobi.announcement.dto.MemberCreateRequestDTO;

import com.example.tobi.announcement.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void createUser(User user);

    User loginUser(User user);

    int checkUser(User user);


}
