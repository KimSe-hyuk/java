package notice;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Class.forName;

public class Noticelmpl implements Notice {
    NoticeDao noticeDao = new NoticeDao();
    private int userID;
    private String userName;
    private boolean status;
    public Noticelmpl(int userID, String userName, boolean status) {
        this.userID = userID;
        this.userName = userName;
        this.status = status;
    }


    public String getNowDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    @Override
    public int printMenu() {        Scanner sc = new Scanner(System.in);
        System.out.println(status?userName:" 로그인하시오");
        System.out.println("1. login 2. joinMembership " +
                "3. postList 4. addPost 5. editPost 6. delPost " +
                "7. logOut 8. delUser 9. end");
        return sc.nextInt();
    }

    @Override
    public void login() {
        if(!status){
            System.out.println("login successful");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("ID : ");
        String id = sc.nextLine();
        System.out.println("Password : ");
        String password = sc.nextLine();



        NoticeDto noticeDto = noticeDao.loin(id,password);
        userID=noticeDto.getUserID();
        userName=noticeDto.getEmail();
        status=noticeDto.getStatus();
    }
    public void joinMembershipPrint(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID : ");
        String id = sc.nextLine();
        if(noticeDao.checkID(id)){
            System.out.println("duplicate id");
            return;
        }
        System.out.println("PW : ");
        String pw = sc.nextLine();
        System.out.println("EMAIL : ");
        String email = sc.nextLine();
        noticeDao.joinMembership(id,pw,email,getNowDateTime());
    }




    @Override
    public void delMembership() {
        if(!status){
            System.out.println("login please");
            return;
        }
        noticeDao.delMembership(userID);
    }

    @Override
    public void viewPostList() {
        if(!status){
            System.out.println("login please");
            return;
        }
        noticeDao.viewPostList();
    }

    @Override
    public void addPost() {
        if(!status){
            System.out.println("login please");
            return;
        }
        noticeDao.addPost(userID,getNowDateTime());
    }

    @Override
    public void editPost() {
        if(!status){
            System.out.println("login please");
            return;
        }
        noticeDao.editPost(userID,getNowDateTime());
    }

    @Override
    public void delPost() {
        Scanner sc = new Scanner(System.in);
        if(!status){
            System.out.println("login please");
            return;
        }
        noticeDao.delPost(userID);
    }

    @Override
    public void logout() {
        if(!status){
            System.out.println("login please");
            return;
        }
        status=false;
        System.out.println("log out");
    }
}
