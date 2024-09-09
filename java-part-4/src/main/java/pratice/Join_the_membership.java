package pratice;

import java.sql.*;
import java.util.Scanner;

import static java.lang.Class.forName;

public class Join_the_membership implements Join_Mem{

    public Connection connection(){
        String url = "jdbc:mysql://localhost:3306/java_basic";
        String user = "root";
        String password = "1234";

        try{
            forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("Conn success!");
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void joinMem(String userId, String pw, String name, int age, String phone) {
        String query = "Insert into member(userId,pw,name,age,phone) values(?,?,?,?,?)";
        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ){
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, pw);
            preparedStatement.setString(3, name);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, phone);

            int result = preparedStatement.executeUpdate();
            if (result>0){
                System.out.println("Join Success!");
            }
           } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    boolean checkId(String userId){
        String query = "select * from member where userId = ?";
        try(
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ){
            preparedStatement.setString(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void printJoinMem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("userId input : ");
        String userId = scanner.nextLine();
        if(checkId(userId)){
            System.out.println("duplication ID");
            return;
        }
        System.out.println("pw input : ");
        String pw = scanner.nextLine();
        System.out.println("name input : ");
        String name = scanner.nextLine();
        System.out.println("age input : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("phone input : ");
        String phone = scanner.nextLine();

        joinMem(userId,pw,name,age,phone);
    }

    @Override
    public void logInMem(String userId, String pw) {
        String query = "Select * from member where userId = ? and pw = ?";

        try(
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ){
            preparedStatement.setString(1,userId);
            preparedStatement.setString(2,pw);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                System.out.println("Welcome! : "+name);
                System.out.println("Age : "+age);
                System.out.println("Phone : "+phone);
            }else{
                System.out.println("Nothing found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printlogInMem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("userId  : ");
        String userId = scanner.nextLine();
        System.out.println("pw  : ");
        String pw = scanner.nextLine();
        logInMem(userId,pw);
    }

    @Override
    public int printMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. MemberJoin 2. Login 3. break");
        return scanner.nextInt();
    }
}
