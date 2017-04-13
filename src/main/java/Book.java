import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Book {

    private String title;
    private String author;
    private int pages;

    public Book() {
    }

    public void addBook(Connection connection) throws SQLException {
        String sql = "INSERT INTO book (title, author, pages) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz tytuł,autora,ilosc stron (po przecinku)");
        String[] book = scanner.nextLine().split(",");

        statement.setString(1, title = book[0]);
        statement.setString(2, author = book[1]);
        statement.setString(3, String.valueOf(pages = Integer.parseInt(book[2])));

        statement.execute();
        statement.close();

        System.out.println("Dodałem książkę!");
    }

    public void showBooks(Connection connection) throws SQLException {
        String sql = "SELECT * FROM book";
        PreparedStatement statement = connection.prepareStatement(sql);
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
