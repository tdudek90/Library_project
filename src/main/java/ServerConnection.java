import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ServerConnection {

    private final String DB = "jdbc:mysql://5.135.218.27:3306/tomekD?useUnicode=true&characterEncoding=UTF-8";
    private final String USER = "tomekD";
    private final String USERPW = "j4j3gI9FfjZ3fTnu";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    public Connection connectToServer() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB, USER, USERPW);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Class.forName(DRIVER).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Statement statement = connection.createStatement();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Connected");
        return connection;
    }
}

