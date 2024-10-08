package com.example.tobi.springtobi.ch05.ex_5_2.dao;

import com.example.tobi.springtobi.ch05.ex_5_2.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void add(User user);
    void deleteAll();
    List<User> getAll();
    User get(String id);
    int getCount() throws SQLException;
    void update(User user);
}
