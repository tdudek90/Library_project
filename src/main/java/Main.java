import java.sql.*;

public class Main {


    public static void main(String[] args) throws SQLException {

        ServerConnection serverConnection = new ServerConnection();
        LibraryMenu libraryMenu = new LibraryMenu();
        User user = new User();
        Book book = new Book();
        boolean ifEnd = false;
        while (!ifEnd) {
            int menu = libraryMenu.menu();
            switch (menu) {
                case 1: {
                    int menuLibrary = libraryMenu.showOptions();
                    switch (menuLibrary) {
                        case 1: {
                            user.addUser(serverConnection.connectToServer());
                        }
                        break;
                        case 2: {
                            book.addBook(serverConnection.connectToServer());
                        }
                        break;
                        case 3: {
                            user.showAllUser(serverConnection.connectToServer());
                        }
                        break;
                        case 4: {
                            book.showBooks(serverConnection.connectToServer());
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


