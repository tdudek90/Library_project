import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class User {

    private String name;
    private String lastName;
    private String phoneNumber;

    public User() {
    }

    public void addUser(Connection connection) throws SQLException {
        String sql = "INSERT INTO user (name, lastName, number) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz imię,nazwisko,numer telefonu (po przecinku)");
        String[] userData = scanner.nextLine().split(",");

        statement.setString(1, name = userData[0]);
        statement.setString(2, lastName = userData[1]);
        statement.setString(3, phoneNumber = userData[2]);

        statement.execute();
        statement.close();

        System.out.println("Dodałem użytkownika!");
    }

}
