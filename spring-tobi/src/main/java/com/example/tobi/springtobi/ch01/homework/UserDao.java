package com.example.tobi.springtobi.ch01.homework;

import com.example.tobi.springtobi.ch01.ex_1_3.dao.ConnectionMaker;
import com.example.tobi.springtobi.ch01.ex_1_3.dao.DConnectionMaker;

import javax.sql.DataSource;

public class UserDao {

    private DataSource dataSource;


    private static UserDao INSTANCE;
    private final ConnectionMaker connectionMaker;

    private UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;

    }
    public static synchronized UserDao getINSTANCE(){
        if(INSTANCE == null) {
            INSTANCE = new UserDao(new DConnectionMaker());
        }
        return INSTANCE;
    }

}
