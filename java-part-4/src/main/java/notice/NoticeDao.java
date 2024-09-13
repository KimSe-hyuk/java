package notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Class.forName;


public class NoticeDao {


    private Connection connection(){
        String url = "jdbc:mysql://localhost:3306/Notice";
        String user = "root";
        String password = "1234";
        try {
            forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,user,password);
            System.out.println("Conn success!");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public NoticeDto  loin(String id,String password) {
        String query = "select * from user where id=? and pw=?";

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
        ) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                System.out.println("login success!");
                return new NoticeDto(rs.getInt("userID"), rs.getString("Email"), true);
            } else {
                System.out.println("login failed!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean checkID(String id) {
        String query = "select * from user where id=?";
        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
        ){
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void joinMembership(String id,String pw,String email, String date) {

        String query = "Insert into user(id,pw,email,date) values(?,?,?,?)";
        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
        ){
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,pw);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,date);

            int update = preparedStatement.executeUpdate();
            if(update>0){
                System.out.println("memberJoin success!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delMembership(int userID) {
        String query = "delete from user where userID=?";
        String query2 = "delete from content where userID=?";
        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                PreparedStatement preparedStatement2 = conn.prepareStatement(query2)
        ){
            preparedStatement.setInt(1, userID);
            preparedStatement2.setInt(1,userID);
            int rs = preparedStatement.executeUpdate();
            int rs2 = preparedStatement2.executeUpdate();
            if(rs>0&&rs2>0){
                System.out.println("user del");
                return;
            }
            System.out.println("user del fail!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void viewPostList() {
        String query = "select * from content";
        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
        ){
            ResultSet rs =preparedStatement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("ContentID")+". "+rs.getString("Contents")
                        + rs.getString("Date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addPost(int userID,String date) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Content : ");
        String content = sc.nextLine();
        String query = "insert into content(userID,Contents,Date) values(?,?,?)";
        try(
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
        ){
            preparedStatement.setInt(1,userID);
            preparedStatement.setString(2, content);
            preparedStatement.setString(3, date);
            int rs = preparedStatement.executeUpdate();
            if(rs>0){
                System.out.println("Post add success!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editPost(int userID,String date) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strings = printPostUserLogin(userID);
        System.out.println("ContentID : ");
        String id = sc.nextLine();
        if(strings.contains(id)){
            System.out.println("edit content : ");
            String content = sc.nextLine();
            String query = "update content set Contents=?,Date=?  where ContentID=?";
            try(
                    Connection conn = connection();
                    PreparedStatement preparedStatement = conn.prepareStatement(query)
            ){
                preparedStatement.setString(1, content);
                preparedStatement.setString(2,date);
                preparedStatement.setString(3, id);
                int rs = preparedStatement.executeUpdate();
                if(rs>0){
                    System.out.println("Post edit success!");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("notingPostNum");
        }
    }
    public ArrayList<String> printPostUserLogin(int userID){
        String query = "select * from content where Userid=?";
        ArrayList<String> ContentId = new ArrayList<>();
        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query)
        ){
            preparedStatement.setInt(1,userID);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                ContentId.add(rs.getString("ContentID"));
                System.out.println(rs.getString("ContentID")+". "+rs.getString("Contents") + rs.getString("Date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ContentId;
    }
    public void delPost(int userID) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strings = printPostUserLogin(userID);
        System.out.println("ContentID : ");
        String id = sc.nextLine();
        if(strings.contains(id)){
            String query = "DELETE FROM content where ContentID = ?";
            try(
                    Connection conn = connection();
                    PreparedStatement preparedStatement = conn.prepareStatement(query)
            ){
                preparedStatement.setString(1, id);

                int rs = preparedStatement.executeUpdate();
                if(rs>0){
                    System.out.println("글 삭제 성공");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("notingPostNum");
        }
    }
}
