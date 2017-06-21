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

    public void showBooks(ServerConnection connection) throws SQLException {
        String sql = "SELECT * FROM book";
        PreparedStatement statement = connection.getNewPrepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("-----------------");
            System.out.println(resultSet.getInt("id"));
            System.out.print(resultSet.getString("title"));
            System.out.println(resultSet.getString("author"));
            System.out.println(resultSet.getString("pages"));

        }

    }

}
