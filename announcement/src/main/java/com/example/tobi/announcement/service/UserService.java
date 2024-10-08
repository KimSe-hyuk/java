package com.example.tobi.announcement.service;

import com.example.tobi.announcement.dto.MemberCreateRequestDTO;
import com.example.tobi.announcement.dto.MemberResponseDTO;
import com.example.tobi.announcement.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import com.example.tobi.announcement.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public boolean createUser(User user) {
        int checkUser = userMapper.checkUser(user);
        if (checkUser == 0) {
            userMapper.createUser(user);
            return true;
        }else{
            return false;
        }
    }


    public MemberResponseDTO loginUser(User user) {
        User us = userMapper.loginUser(user);
        if(us!=null){
            return us.toMemberListResponseDTO();
        };
        return null;
    }
}
