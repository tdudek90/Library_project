import java.sql.*;

public class Main {


    public static void main(String[] args) throws SQLException {

        ServerConnection connection = ServerConnection.getInstance();
        LibraryMenu libraryMenu = new LibraryMenu();
        User user = new User();
        Book book = new Book();
        Rent rent = new Rent();
        UserDAO userDAO = new UserDAO();
        boolean ifEnd = false;
        while (!ifEnd) {
            int menu = libraryMenu.menu();
            switch (menu) {
                case 1: {
                    int menuLibrary = libraryMenu.showOptions();
                    switch (menuLibrary) {
                        case 1: {
                            userDAO.addUser(connection,new User());
//                            user.addUser(connection);
                        }
                        break;
                        case 2: {
                            book.addBook(connection);
                        }
                        break;
                        case 3: {
                            user.showAllUser(connection);
                        }
                        break;
                        case 4: {
                            book.showBooks(connection);
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


