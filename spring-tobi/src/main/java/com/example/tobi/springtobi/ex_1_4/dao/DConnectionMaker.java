package com.example.tobi.springtobi.ex_1_4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {
    @Override
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
            String URL = "jdbc:mysql://localhost:3306/spring_tobi";
            String USER = "root";
            String PASSWORD = "1234";

            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
