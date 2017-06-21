import java.sql.*;
import java.util.Scanner;

public class LibraryMenu {

    public int menu() {
        System.out.println("1. Start");
        System.out.println("2. Quit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int showOptions() {
        System.out.println("Options");
        System.out.println("1. Add user");
        System.out.println("2. Add book");
        System.out.println("3. Show all users");
        System.out.println("4. Show all books");
        System.out.println("5. Add rent");
        System.out.println("6. Show rented books");
        System.out.println("7. Edit user");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void sayGoodBye() {
        System.out.println("Goodbye");
    }


}
