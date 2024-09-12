package notice;

/*
Notice 데이터베이스 생성
CREATE DATABASE Notice
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;
User 테이블-> 회원정보
CREATE TABLE user (
                     userID int(10)NOT NULL AUTO_INCREMENT PRIMARY KEY,
                     Id VARCHAR(10) NOT NULL,
                     Pw VARCHAR(10) NOT NULL,
                     Email VARCHAR(20),
                     Date DATE
);
CREATE TABLE content (
                      ContentID int(10)NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      Userid int(10),
                      Contents VARCHAR(10) NOT NULL,
                      Date VARCHAR(10) NOT NULL
);
Content 테이블 -> 공지사항 내용
설계 후 생성

기능
public int printMenu();
public void login();
public void joinMembership() ;
public void delMembership();
public void viewPostList();
public void addPost();
public void editPost();
public void delPost();

 */
public class Start {
    public static void main(String[] args) {
        Notice joinMem = new Noticelmpl(0,null,false);
        while (true){
            int selectNum =joinMem.printMenu();
            switch (selectNum){
                case 1:
                    joinMem.login();
                    break;
                case 2:
                    joinMem.joinMembershipPrint();
                    break;
                case 3:
                    joinMem.viewPostList();
                    break;
                case 4:
                    joinMem.addPost();
                    break;
                case 5:
                    joinMem.editPost();
                    break;
                case 6:
                    joinMem.delPost();
                    break;
                case 7:
                    joinMem.logout();
                case 8:
                    joinMem.delMembership();
                    break;
                case 9:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못 누름");
                    break;
            }
        }
    }
}
