import java.sql.*;

public class Main {


    public static void main(String[] args) throws SQLException {

        ServerConnection connection = ServerConnection.getInstance();
        LibraryMenu libraryMenu = new LibraryMenu();
        Rent rent = new Rent();
        User user = new User();
        Book book = new Book();
        UserDAO userDAO = new UserDAO();
        BookDAO bookDAO = new BookDAO();
        boolean ifEnd = false;
        while (!ifEnd) {
            int menu = libraryMenu.menu();
            switch (menu) {
                case 1: {
                    int menuLibrary = libraryMenu.showOptions();
                    switch (menuLibrary) {
                        case 1: {
                            userDAO.addUser(connection,user);
                            break;
                        }
                        case 2: {
                            bookDAO.addBook(connection,book);
                            break;
                        }
                        case 3: {
                            userDAO.showAllUser(connection);
                            break;
                        }
                        case 4: {
                            bookDAO.showBooks(connection);
                            break;
                        }
                        case 5: {
                            rent.addRent(connection);
                            break;
                        }
                        case 6: {
                            rent.showRentedBooks(connection);
                            break;
                        }
                        case 7:{
                            userDAO.editUser(connection, user);
                            break;
                        }
                        case 8:{
                            userDAO.deleteUser(connection);
                            break;
                        }
                        case 9:{
                            bookDAO.deleteBook(connection);
                            break;
                        }
                        case 10:{
                            bookDAO.editBook(connection,book);
                            break;
                        }
                        case 11:{
                            rent.showRents(connection);
                            break;
                        }
                    }
                }
                break;
                case 2: {
                    libraryMenu.sayGoodBye();
                    ifEnd = true;
                    break;

                }
            }

        }
    }
}


