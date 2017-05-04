import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Tomek on 2017-04-20.
 */
public class Rent {

    private int bookID;
    private int userID;


    public void addRent(ServerConnection connection) throws SQLException {
        String sql = "INSERT INTO rent (book, user) VALUES (?,?)";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book ID, user ID)");
        String[] book = scanner.nextLine().split(",");

        statement.setString(1, String.valueOf(bookID = Integer.parseInt(book[0])));
        statement.setString(2, String.valueOf(userID = Integer.parseInt(book[1])));

        statement.execute();
        statement.close();

        System.out.println("Rent has been added!");
    }

    public void showRentedBooks(ServerConnection connection) throws SQLException {
        String sql = "SELECT * FROM rent";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("-----------------");
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getInt("book"));
            System.out.println(resultSet.getInt("user"));
            System.out.println(resultSet.getString("rentTime"));
        }
    }


}
