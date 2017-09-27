
public class Main {


    public static void main(String[] args)  {

        ServerConnection connection = ServerConnection.getInstance();
        LibraryMenu libraryMenu = new LibraryMenu();
        Rent rent = new Rent();
        User user = new User();
        Book book = new Book();
        UserDAO userDAO = new UserDAO();
        BookDAO bookDAO = new BookDAO();
        RentDAO rentDAO = new RentDAO();
        boolean ifEnd = false;
        while (!ifEnd) {
            int menu = libraryMenu.menu();
            switch (menu) {
                case 1: {
                    int menuLibrary = libraryMenu.showOptions();
                    switch (menuLibrary) {
                        case 1: {
                            userDAO.addUser(connection, user);
                            break;
                        }
                        case 2: {
                            bookDAO.addBook(connection, book);
                            break;
                        }
                        case 3: {
                            rentDAO.addRent(connection,user,book);
                            break;
                        }
                        case 4: {
                            userDAO.showAllUser(connection);
                            break;
                        }
                        case 5: {
                            bookDAO.showBooks(connection);
                            break;
                        }
                        case 6: {
                            rentDAO.showRentedBooks(connection);
                            break;
                        }
                        case 7: {
                            rentDAO.showRents(connection);
                            break;
                        }
                        case 8: {
                            userDAO.editUser(connection, user);
                            break;
                        }
                        case 9: {
                            bookDAO.editBook(connection, book);
                            break;
                        }
                        case 10: {
                            userDAO.deleteUser(connection);
                            break;
                        }
                        case 11: {
                            bookDAO.deleteBook(connection);
                            break;
                        }
                        case 12: {
                            rentDAO.deleteRent(connection);
                            break;
                        }case 13: {
                            rentDAO.editRent(connection, rent);
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


