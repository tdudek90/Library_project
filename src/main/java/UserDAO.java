import java.sql.PreparedStatement;
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



}