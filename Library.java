import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String name;
    int count;

    Book(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return name + " (Copies: " + count + ")";
    }
}

class Books {
    ArrayList<Book> horrorBooks = new ArrayList<>();
    ArrayList<Book> comedyBooks = new ArrayList<>();
    ArrayList<Book> loveBooks = new ArrayList<>();

    public void addBook(String type, String name, int count) {
        Book book = new Book(name, count);
        switch (type.toLowerCase()) {
            case "horror":
                horrorBooks.add(book);
                System.out.println("Added Horror book: " + book);
                break;
            case "comedy":
                comedyBooks.add(book);
                System.out.println("Added Comedy book: " + book);
                break;
            case "love":
                loveBooks.add(book);
                System.out.println("Added Love book: " + book);
                break;
            default:
                System.out.println("Invalid book type!");
        }
    }

    public void showBooks() {
        System.out.println("\n--- Library Books ---");
        System.out.println("Horror: " + horrorBooks);
        System.out.println("Comedy: " + comedyBooks);
        System.out.println("Love: " + loveBooks);
    }
}

public class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Books library = new Books();
        int choice;

        do {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter type of book (Horror/Comedy/Love): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter book name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the number of copies: ");
                    int count = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    library.addBook(type, name, count);
                    break;
                case 2:
                    library.showBooks();
                    break;
                case 3:
                    System.out.println("Exiting Library...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);

        scanner.close();
    }
}