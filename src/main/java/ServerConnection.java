import java.sql.*;


public class ServerConnection {

    private final String DB = "jdbc:mysql://5.135.218.27:3306/tomekD?useUnicode=true&characterEncoding=UTF-8";
    private final String USER = "tomekD";
    private final String USERPW = "j4j3gI9FfjZ3fTnu";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    private static ServerConnection ourInstance = new ServerConnection();

    public static ServerConnection getInstance() {
        return ourInstance;
    }

    private Connection connection;

    private ServerConnection() {
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
            connection = DriverManager.getConnection(DB, USER, USERPW);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connected");
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getNewStatement() {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PreparedStatement getNewPrepareStatement(String sql) {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
