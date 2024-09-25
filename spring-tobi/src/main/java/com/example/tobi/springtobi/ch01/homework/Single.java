package com.example.tobi.springtobi.ch01.homework;

public class Single {
    public static void main(String[] args) {
        UserDao userDao = UserDao.getINSTANCE(); // 싱글턴 인스턴스 가져오기
        UserDao userDao2 = UserDao.getINSTANCE(); // 싱글턴 인스턴스 가져오기
        System.out.println(userDao);
        System.out.println(userDao2);
        System.out.println(userDao.equals(userDao2));
    }
}
