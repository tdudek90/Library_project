import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class UserDAO {

    public void addUser(ServerConnection serverConnection, User user) throws SQLException {
        String sql = "INSERT INTO user (name, lastName, number) VALUES (?,?,?)";
        PreparedStatement statement = serverConnection.getNewPrepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name, lastname, phone number(after the decimal point)");
        String[] userData = scanner.nextLine().split(",");

        user.setName(userData[0]);
        user.setLastName(userData[1]);
        user.setPhoneNumber(userData[2]);

        statement.setString(1, userData[0] = user.getName());
        statement.setString(2, userData[1] = user.getLastName());
        statement.setString(3, userData[2] = user.getPhoneNumber());

        statement.execute();
        statement.close();

        System.out.println("User has been added!");
    }

    public void editUser(ServerConnection serverConnection, User user) throws SQLException {
        String sql = "UPDATE user SET name=?, lastName=?, number=? WHERE id=?";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name, lastname, phone number (after the decimal point)");
        PreparedStatement statement = serverConnection.getNewPrepareStatement(sql);
        String[] userData = scanner.nextLine().split(",");

        System.out.println("Enter user id to edit");
        int id = scanner.nextInt();
        user.setName(userData[0]);
        user.setLastName(userData[1]);
        user.setPhoneNumber(userData[2]);


        statement.setString(1, userData[0] = user.getName());
        statement.setString(2, userData[1] = user.getLastName());
        statement.setString(3, userData[2] = user.getPhoneNumber());
        statement.setInt(4,id );

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("User has been edited!");
        }

    }


    public void showAllUser(ServerConnection serverConnection) throws SQLException {
        String sql = "SELECT * FROM user";
        PreparedStatement statement = serverConnection.getNewPrepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("-----------------");
            System.out.println(resultSet.getInt("id"));
            System.out.print(resultSet.getString("name"));
            System.out.println(resultSet.getString("lastName"));
            System.out.println("-----------------");

        }
    }


}
