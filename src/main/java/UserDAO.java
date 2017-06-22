import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class UserDAO {

    public void addUser(ServerConnection serverConnection, User user) throws SQLException {
        String sql = "INSERT INTO user (name, lastName, number, password) VALUES (?,?,?,?)";
        PreparedStatement statement = serverConnection.getNewPrepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name, lastname, phone number and password (after the decimal point)");
        String[] userData = scanner.nextLine().split(",");

        user.setName(userData[0]);
        user.setLastName(userData[1]);
        user.setPhoneNumber(userData[2]);
        user.setPassword(userData[3]);

        statement.setString(1, userData[0] = user.getName());
        statement.setString(2, userData[1] = user.getLastName());
        statement.setString(3, userData[2] = user.getPhoneNumber());
        statement.setString(4, userData[3] = user.getPassword());

        statement.execute();
        statement.close();

        System.out.println("User has been added!");
    }

    public void editUser(ServerConnection serverConnection, User user) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user ID to edit");
        int id = scanner.nextInt();

        Scanner sc = new Scanner(System.in);
        String sql = "UPDATE user SET name=?, lastName=?, number=?, password=? WHERE id=?";
        PreparedStatement statement = serverConnection.getNewPrepareStatement(sql);
        System.out.println("Enter name, lastname, phone number and password (after the decimal point)");
        String[] userData = sc.nextLine().split(",");

        user.setName(userData[0]);
        user.setLastName(userData[1]);
        user.setPhoneNumber(userData[2]);
        user.setPassword(userData[3]);

        statement.setString(1, userData[0] = user.getName());
        statement.setString(2, userData[1] = user.getLastName());
        statement.setString(3, userData[2] = user.getPhoneNumber());
        statement.setString(4, userData[3] = user.getPassword());
        statement.setInt(5, id);

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
            System.out.println("ID: " + resultSet.getInt("id"));
            System.out.println("Name: " + resultSet.getString("name"));
            System.out.println("Lastname: " + resultSet.getString("lastName"));
            System.out.println("Number: " + resultSet.getString("number"));
            System.out.println("-----------------");

        }
    }

    public void deleteUser(ServerConnection serverConnection) throws SQLException {
        String sql = "DELETE from user WHERE id = ?";
        PreparedStatement statement = serverConnection.getNewPrepareStatement(sql);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user ID to delete");
        int ID = scanner.nextInt();

        statement.setInt(1, ID);

        statement.execute();
        statement.close();

        System.out.println("User has been deleted!");
    }


}
