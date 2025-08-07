import java.util.*;
import java.util.ArrayList;
import java.util.List;
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issue() { isIssued = true; }
    public void returnBook() { isIssued = false; }

    public void displayBookInfo() {
        System.out.println("[" + id + "] " + title + " by " + author + (isIssued ? " (Issued)" : ""));
    }
}



class User {
    private int userId;
    private String userName;
    private List<Book> issuedBooks = new ArrayList<>();

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId() { return userId; }
    public String getUserName() { return userName; }

    public void issueBook(Book book) {
        if (book != null && !book.isIssued()) {
            issuedBooks.add(book);
            book.issue();
            System.out.println("Book issued: " + book.getTitle());
        } else {
            System.out.println("Cannot issue. Book not available.");
        }
    }

    public void returnBook(Book book) {
        if (issuedBooks.remove(book)) {
            book.returnBook();
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("You did not issue this book.");
        }
    }

    public void showIssuedBooks() {
        System.out.println("Books issued to " + userName + ":");
        if (issuedBooks.isEmpty()) {
            System.out.println("None");
        } else {
            for (Book b : issuedBooks) {
                System.out.println("- " + b.getTitle());
            }
        }
    }
}





public class Library {
    private static List<Book> books = new ArrayList<>();
    private static Map<Integer, User> users = new HashMap<>();

    public static void main(String[] args) {
        setupDummyData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📚 Library Menu");
            System.out.println("1. View Books");
            System.out.println("2. Register User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Issued Books");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: showAllBooks(); break;
                case 2: registerUser(scanner); break;
                case 3: issueBookToUser(scanner); break;
                case 4: returnBookFromUser(scanner); break;
                case 5: showUserBooks(scanner); break;
                case 0: System.exit(0);
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void setupDummyData() {
        books.add(new Book(1, "Java Programming", "James Gosling"));
        books.add(new Book(2, "OOP Concepts", "Alan Kay"));
    }

    private static void showAllBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            book.displayBookInfo();
        }
    }

    private static void registerUser(Scanner sc) {
        System.out.print("Enter user ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter user name: ");
        String name = sc.nextLine();
        users.put(id, new User(id, name));
        System.out.println("User registered successfully.");
    }

    private static void issueBookToUser(Scanner sc) {
        Book book = findBook(sc);
        User user = findUser(sc);
        if (book != null && user != null) {
            user.issueBook(book);
        }
    }

    private static void returnBookFromUser(Scanner sc) {
        Book book = findBook(sc);
        User user = findUser(sc);
        if (book != null && user != null) {
            user.returnBook(book);
        }
    }

    private static void showUserBooks(Scanner sc) {
        User user = findUser(sc);
        if (user != null) {
            user.showIssuedBooks();
        }
    }

    private static Book findBook(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        for (Book b : books) {
            if (b.getId() == bookId) return b;
        }
        System.out.println("Book not found.");
        return null;
    }

    private static User findUser(Scanner sc) {
        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User not found.");
        }
        return user;
    }
}
