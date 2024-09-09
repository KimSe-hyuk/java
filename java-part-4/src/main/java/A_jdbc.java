import java.sql.*;

public class A_jdbc {

    public Connection connection() {
        String url ="jdbc:mysql://localhost:3306/java_basic";
        String user = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conn Success!");
            return connection;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    // sql injection
    public void insertData(String name, int age, String phone){
        String query = "Insert into users(name,age,phone) values(?,?,?)";
        try(
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ){
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,phone);

            int result = preparedStatement.executeUpdate();
            if(result >0){
                System.out.println("Insert Success!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(int id, String name, int age, String phone){
        String query = "Update users set name=?,age=?,phone=? where id=?";
        try(
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ){
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,phone);
            preparedStatement.setInt(4,id);
            int result = preparedStatement.executeUpdate();
            if(result >0){
                System.out.println("Update Success!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteData(int id){
        String query = "Delete from users where id=?";

        try(
            Connection conn = connection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
                ) {
            preparedStatement.setInt(1, id);

            int result = preparedStatement.executeUpdate();
            if(result >0){
                System.out.println("Delete Success!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectAll(){
        String query = "Select * from users";
        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");

                System.out.println(id  + " :  " + name + " : " + age + " : " + phone);
                System.out.println("==============================");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectOne(int id){
        String query = "Select id, name, age, phone from users where id=?";

        try (
                Connection conn = connection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");

                System.out.println(id  + " :  " + name + " : " + age + " : " + phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        A_jdbc jdbc = new A_jdbc();
        //jdbc.connection();
//        jdbc.insertData("Alice",11,"010-1234-5678");
//        jdbc.insertData("Alice",12,"010-4444-3333");
//        jdbc.insertData("Alice",13,"010-1111-2222");
        //jdbc.updateData(7,"Sally",13,"010-1111-2222");
        //jdbc.deleteData(7);
        //jdbc.selectOne(7);
        jdbc.selectAll();
    }
}
