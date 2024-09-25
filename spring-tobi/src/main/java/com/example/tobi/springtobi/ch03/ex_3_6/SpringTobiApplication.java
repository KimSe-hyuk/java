package com.example.tobi.springtobi.ch03.ex_3_6;

import com.example.tobi.springtobi.ch03.ex_3_6.dao.DaoFactory;
import com.example.tobi.springtobi.ch03.ex_3_6.dao.UserDao_v1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class SpringTobiApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        setCharacter();

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao_v1 userDaoV1 = context.getBean("userDao", UserDao_v1.class);

        int count = userDaoV1.getCount();
        System.out.println(count);

        userDaoV1.deleteAll();

        count = userDaoV1.getCount();
        System.out.println(count);
        System.out.println(userDaoV1.getAll());

    }

    private static void setCharacter() {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}