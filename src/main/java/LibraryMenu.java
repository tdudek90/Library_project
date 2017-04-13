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

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void sayGoodBye() {
        System.out.println("See you later");
    }
}
