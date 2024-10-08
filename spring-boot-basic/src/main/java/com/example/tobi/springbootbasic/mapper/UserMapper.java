package com.example.tobi.springbootbasic.mapper;

import com.example.tobi.springbootbasic.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();
    void insertUser(User user);
    User findOne(Long id);
    //int checkPassword(String password);
    //void updateUser(@Param("id") Long id, @Param("user") User user);
    void updateUser(User user);
    void deleteUser(User user);
    //int checkUserExists(User user);
}