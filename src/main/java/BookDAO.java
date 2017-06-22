import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Tomek on 2017-06-21.
 */
public class BookDAO {

    public void addBook(ServerConnection connection, Book book) throws SQLException {
        String sql = "INSERT INTO book (title, author, pages) VALUES (?,?,?)";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title, author and number of pages(after the decimal point)");
        String[] newBook = scanner.nextLine().split(",");

        book.setTitle(newBook[0]);
        book.setAuthor(newBook[1]);
        book.setPages(Integer.parseInt(newBook[2]));

        statement.setString(1, newBook[0] = book.getTitle());
        statement.setString(2, newBook[1] = book.getAuthor());
        statement.setString(3, newBook[2] = String.valueOf(book.getPages()));

        statement.execute();
        statement.close();

        System.out.println("Book has been added!");
    }

    public void deleteBook(ServerConnection connection) throws SQLException {
        String sql = "DELETE from book WHERE id =?";
        Scanner scanner = new Scanner(System.in);
        int ID = scanner.nextInt();
        PreparedStatement statement = connection.getNewPrepareStatement(sql);

        statement.setInt(1, ID);

        statement.execute();
        statement.close();

        System.out.println("Book has been deleted");

    }

    public void showBooks(ServerConnection connection) throws SQLException {
        String sql = "SELECT * FROM book";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("-----------------");
            System.out.println("ID: " + (resultSet.getInt("id")));
            System.out.println("Title: " + (resultSet.getString("title")));
            System.out.println("Author: " + (resultSet.getString("author")));
            System.out.println("Pages: " + (resultSet.getString("pages")));

        }

    }

    public void editBook(ServerConnection connection, Book book) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book ID to edit");
        int id = scanner.nextInt();

        Scanner sc = new Scanner(System.in);
        String sql = "UPDATE book SET title=?, author=?, pages=? WHERE id=?";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        System.out.println("Enter title, author, pages (after the decimal point)");
        String[] userData = sc.nextLine().split(",");

        book.setTitle(userData[0]);
        book.setAuthor(userData[1]);
        book.setPages(Integer.parseInt(userData[2]));

        statement.setString(1, userData[0] = book.getTitle());
        statement.setString(2, userData[1] = book.getAuthor());
        statement.setString(3, userData[2] = String.valueOf(book.getPages()));
        statement.setInt(4, id);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("User has been edited!");
        }
    }

}
