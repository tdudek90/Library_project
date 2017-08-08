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

    public Rent() {
    }

    public Rent(int bookID, int userID) {
        this.bookID = bookID;
        this.userID = userID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
