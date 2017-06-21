import java.sql.*;

public class Main {


    public static void main(String[] args) throws SQLException {

        ServerConnection connection = ServerConnection.getInstance();
        LibraryMenu libraryMenu = new LibraryMenu();
//        User user = new User();
//        Book book = new Book();
        Rent rent = new Rent();
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
                            userDAO.addUser(connection,new User());
                        }
                        break;
                        case 2: {
                            bookDAO.addBook(connection,new Book());
                        }
                        break;
                        case 3: {
                            userDAO.showAllUser(connection);
                        }
                        break;
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


