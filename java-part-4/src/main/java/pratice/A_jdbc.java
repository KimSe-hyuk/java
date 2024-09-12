package pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class A_jdbc {

    public Connection connection(){
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "1234";

        try {
            forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url, user, password);
            System.out.println("Conn success!");
            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertData(String name, int age, String phone){
        String query = "Insert into names(name,age,phone) values(?,?,?)";

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, phone);

            int result = preparedStatement.executeUpdate();
            if(result>0){
                System.out.println("Data inserted successfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteData(int id){

    }

    public static void main(String[] args) {

    }
}
