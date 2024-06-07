package LibraryApps;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static BookDemo bookDemo = new BookDemo();
    //private static BorrowDAO borrowDAO = new BorrowDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. View Books");
            System.out.println("5. Exit");
            System.out.println("You want to Choose(1-5) : ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            try {
                switch (choice) {
                    case 1:
                        addBook(scanner);
                        break;
                    case 2:
                        updateBook(scanner);
                        break;
                    case 3:
                        deleteBook(scanner);
                        break;
                    case 4:
                        viewBooks();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void addBook(Scanner scanner) throws SQLException {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter book author:");
        String author = scanner.nextLine();
        System.out.println("Enter book publisher:");
        String publisher = scanner.nextLine();
        System.out.println("Enter book year:");
        int year = scanner.nextInt();

        Book book = new Book(title, author, publisher, year);
        bookDemo.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void updateBook(Scanner scanner) throws SQLException {
        System.out.println("Enter book id to update:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter new book title:");
        String title = scanner.nextLine();
        System.out.println("Enter new book author:");
        String author = scanner.nextLine();
        System.out.println("Enter new book publisher:");
        String publisher = scanner.nextLine();
        System.out.println("Enter new book year:");
        int year = scanner.nextInt();

        Book book = new Book(id, title, author, publisher, year);
        bookDemo.updateBook(book);
        System.out.println("Book updated successfully.");
    }

    private static void deleteBook(Scanner scanner) throws SQLException {
        System.out.println("Enter book id to delete:");
        int id = scanner.nextInt();
        bookDemo.deleteBook(id);
        System.out.println("Book deleted successfully.");
    }

    private static void viewBooks() throws SQLException {
        List<Book> books = bookDemo.getAllBooks();
    		for (Book book : books) {
    			System.out.println(book);
        }
    }

    }
//}