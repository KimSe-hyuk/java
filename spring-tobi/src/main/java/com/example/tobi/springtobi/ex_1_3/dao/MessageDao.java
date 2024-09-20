package com.example.tobi.springtobi.ex_1_3.dao;

import com.example.tobi.springtobi.ex_1_3.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDao {

    //private SimpleConnectionMaker simpleConnectionMaker;
    private ConnectionMaker connectionMaker;

    public MessageDao(ConnectionMaker connectionMaker) {
      //  simpleConnectionMaker = new SimpleConnectionMaker();
       // connectionMaker = new DConnectionMaker();
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection conn = connectionMaker.makeNewConnection();
        PreparedStatement ps = conn.prepareStatement("insert into user(id,name,password) values(?,?,?)");

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();

        ps.close();
        conn.close();
    }
    
    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection conn = connectionMaker.makeNewConnection();
        PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");

        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();

        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        conn.close();

        return user;
    }
}
