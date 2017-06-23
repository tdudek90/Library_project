import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
        System.out.println("Enter user ID, book ID)");

        String[] book = scanner.nextLine().split(",");

        statement.setString(1, String.valueOf(userID = Integer.parseInt(book[0])));
        statement.setString(2, String.valueOf(bookID = Integer.parseInt(book[1])));
        if (!(isUserExist(connection, userID) && isBookExist(connection, bookID) && !isBookRented(connection, bookID))) {
            return;
        } else {
            statement.execute();
            statement.close();

            System.out.println("Rent has been added!");
        }
    }


    public void showRentedBooks(ServerConnection connection) throws SQLException {
        String sql = "SELECT * FROM rent";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("-----------------");
            System.out.println("ID: " + resultSet.getInt("id"));
            System.out.println("Book: " + resultSet.getInt("book"));
            System.out.println("User: " + resultSet.getInt("user"));
            System.out.println("Rent time: " + resultSet.getString("rentTime"));
        }
    }

    public void showRents(ServerConnection connection) throws SQLException {
        String sql = "SELECT  user.name, user.lastName, book.title, rent.id, rent.rentTime FROM user, rent, book WHERE user.id = rent.user AND book.id = rent.book";

        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(", ");
                String columnValue = resultSet.getString(i);
                System.out.print(columnValue + "" );
            }
            System.out.println("");
    }}

    private boolean isUserExist(ServerConnection connection, int ID) throws SQLException {
        String sql = "SELECT * FROM user WHERE id = ?";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        statement.setInt(1, ID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            System.out.println("User exist");
            return true;
        } else {
            System.out.println("User does not exist");
            return false;
        }
    }

    private boolean isBookExist(ServerConnection connection, int ID) throws SQLException {
        String sql = "SELECT * FROM book WHERE id = ?";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        statement.setInt(1, ID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            System.out.println("Book exist");
            return true;
        } else {
            System.out.println("Book does not exist");
            return false;
        }
    }

    private boolean isBookRented(ServerConnection connection, int ID) throws SQLException {
        String sql = "SELECT *FROM rent WHERE book = ? ";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        statement.setInt(1, ID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            System.out.println("Book is rented");
            return true;
        } else {
            System.out.println("Book is not rented");
            return false;
        }
    }


}
