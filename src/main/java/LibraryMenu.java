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
        System.out.println("3. Add rent");
        System.out.println("4. Show all users");
        System.out.println("5. Show all books");
        System.out.println("6. Show rented books");
        System.out.println("7. Show rents");
        System.out.println("8. Edit user");
        System.out.println("9. Edit book");
        System.out.println("10. Delete user");
        System.out.println("11. Delete book");
        System.out.println("12. Delete rent");
        System.out.println("13. Edit rent");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void sayGoodBye() {
        System.out.println("Goodbye");
    }


}
