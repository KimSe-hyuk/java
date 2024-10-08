package com.example.tobi.springbootbasic.service;

import com.example.tobi.springbootbasic.dto.MemberCreateRequestDTO;
import com.example.tobi.springbootbasic.dto.MemberResponseDTO;
import com.example.tobi.springbootbasic.mapper.UserMapper;
import com.example.tobi.springbootbasic.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public List<MemberResponseDTO> findAll(){
        List<User> users = userMapper.findAll();
        //방법1
//        List<MemberListResponseDTO> members = new ArrayList<>();
//        for(User user : users){
//            members.add(user.toMemberListResponseDTO());
//        }
//        return members;
        //방법 2
        return users.stream()
                .map(User::toMemberListResponseDTO)
                .collect(Collectors.toList());
    }
    public void createUser(User user){
        userMapper.insertUser(user);
    }

    public MemberResponseDTO findOne(Long id) {
        return userMapper.findOne(id)
                .toMemberListResponseDTO();
    }

//    public boolean deleteUser(User user) {
//        if(userMapper.checkUserExists(user)>0){
//            userMapper.deleteUser(user);
//            return true;
//        }else{
//            return false;
//        }
//
//    }
    public void deleteUser(User user) {
        userMapper.deleteUser(user);
    }
    /*public boolean updateUser(Long id, User user) {
        if(userMapper.checkPassword(user.getPassword())>0){
            userMapper.updateUser(id, user);
            return true;
        }
        return false;
    }*/
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

}