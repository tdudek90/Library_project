import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;


public class RentDAO {

    public void addRent(ServerConnection connection, User user, Book book) {
        String sql = "INSERT INTO rent (user, book) VALUES (?,?)";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user ID, book ID)");

        String[] rentData = scanner.nextLine().split(",");

        user.setUserID(Integer.parseInt(rentData[0]));
        book.setBookID(Integer.parseInt(rentData[1]));


        try {
            statement.setInt(1, Integer.parseInt(rentData[0] = String.valueOf(user.getUserID())));
            statement.setInt(2, Integer.parseInt(rentData[1] = String.valueOf(book.getBookID())));
            if ((!((isUserExist(connection, user.getUserID()) & (isBookExist(connection, book.getBookID()))) & (!isBookRented(connection, book.getBookID()))))) {
                return;
            } else {
                statement.execute();
                statement.close();

                System.out.println("Rent has been added!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showRentedBooks(ServerConnection connection) {
        String sql = "SELECT * FROM rent";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("-----------------");
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Book: " + resultSet.getInt("book"));
                System.out.println("User: " + resultSet.getInt("user"));
                System.out.println("Rent time: " + resultSet.getString("rentTime"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showRents(ServerConnection connection) {
        String sql = "SELECT user.name, user.lastName, book.title, rent.id, rent.rentTime FROM user, rent, book WHERE user.id = rent.user AND book.id = rent.book";

        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(", ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + "");
                }
                System.out.println("");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRent(ServerConnection connection) {
        String sql = "DELETE FROM rent WHERE id =?";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        System.out.println("Enter rent ID to delete");
        Scanner scanner = new Scanner(System.in);
        int ID = scanner.nextInt();

        try {
            statement.setInt(1, ID);
            statement.execute();
            statement.close();
            System.out.println("Rent has been deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void editRent(ServerConnection connection, Rent rent) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter rent ID to edit");
        int id = scanner.nextInt();

        Scanner sc = new Scanner(System.in);
        String sql = "UPDATE rent SET user=?, book=? WHERE id=?";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        System.out.println("Enter userID and bookID (after the decimal point)");
        String[] userData = sc.nextLine().split(",");

        rent.setUserID(Integer.parseInt(userData[0]));
        rent.setBookID(Integer.parseInt(userData[1]));

        try {
            statement.setString(1, userData[0] = String.valueOf(rent.getUserID()));
            statement.setString(2, userData[1] = String.valueOf(rent.getBookID()));
            statement.setInt(3, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Rent has been edited!");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

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
            System.out.println("Book is rented. Choose another one");
            return true;
        } else {
            System.out.println("Book is not rented");
            return false;
        }
    }
}
