import java.sql.*;
import java.util.Scanner;


public class User {

    private String name;
    private String lastName;
    private String phoneNumber;


    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public User(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

//    public void addUser(ServerConnection serverConnection) throws SQLException {
//        String sql = "INSERT INTO user (name, lastName, number) VALUES (?,?,?)";
//        PreparedStatement statement = serverConnection.getNewPrepareStatement(sql);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter name, lastname, phone number(after the decimal point)");
//        String[] userData = scanner.nextLine().split(",");
//
//        statement.setString(1, name = userData[0]);
//        statement.setString(2, lastName = userData[1]);
//        statement.setString(3, phoneNumber = userData[2]);
//
//        statement.execute();
//        statement.close();
//
//        System.out.println("User has been added!");
//    }
//
//    public void showAllUser(ServerConnection connection) throws SQLException {
//        String sql = "SELECT * FROM user";
//        Statement statement = connection.getNewStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        while (resultSet.next()) {
//            System.out.println("-----------------");
//            System.out.println(resultSet.getInt("id"));
//            System.out.print(resultSet.getString("name"));
//            System.out.println(resultSet.getString("lastName"));
//            System.out.println("-----------------");
//
//        }
//
//    }
}
