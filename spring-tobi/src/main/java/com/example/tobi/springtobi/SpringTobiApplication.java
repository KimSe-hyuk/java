package com.example.tobi.springtobi;

import com.example.tobi.springtobi.ch01.ex_1_5.dao.CountingConnectionMaker;
import com.example.tobi.springtobi.ch01.ex_1_5.dao.CountingDaoFactory;
import com.example.tobi.springtobi.ch01.ex_1_5.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class SpringTobiApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        setCharacter();
        ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);

        dao.get("tobi");
        dao.get("tobi");
        dao.get("tobi");


        CountingConnectionMaker connectionMaker = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Conn count : " + connectionMaker.getCounter());
        /*
        UserDao dao = context.getBean("userDao", UserDao.class);
        dao.get("tobi");
        User user = new User();
        user.setId("3940");
        user.setName("123");
        user.setPassword("4321");

        dao.add(user);

        User user1 = dao.get(user.getId());
        System.out.println("aa " + user1.getName());*/

//        CountingConnectionMaker connectionMaker = context.getBean("connectionMaker", CountingConnectionMaker.class);

//        System.out.println("Conn count : " + connectionMaker.getCounter());
        /*ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);

        UserDao dao2 = new DaoFactory().userDao();
        UserDao dao3 = new DaoFactory().userDao();
        System.out.println("dao2 : " + dao2);
        System.out.println("dao3 : " + dao3);

        User user = new User();
        user.setId("tobi6");
        user.setName("Tobi");
        user.setPassword("1234");

        dao.add(user);

        System.out.println(user.getId() + " 등록성공!");

        User getUser = dao.get(user.getId());

        System.out.println(getUser.getName());
        System.out.println(getUser.getPassword());

        System.out.println(getUser.getId() + " 조회 성공");*/

    }

    private static void setCharacter() {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}