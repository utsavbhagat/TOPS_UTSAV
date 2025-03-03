import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Book {
    int id;
    String bookName;
    String author;
    String category;
    int quantity;
    double price;
    
    public Book(int id, String bookName, String author, String category, int quantity, double price) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Book ID: " + id + ", Book Name: " + bookName + ", Author: " + author + ", Category: " + category + ", Quantity: " + quantity + ", Price: $" + price;
    }
}




public class LibraryManagementSystem {
	 private static final Scanner scanner = new Scanner(System.in);
	    private static final List<Book> books = new ArrayList<>();
	    private static final Set<Book> bookSet = new HashSet<>();
	    private static String password = "123";
	    
	    public static void main(String[] args) {
	        System.out.print("Enter Password: ");
	        String inputPassword = scanner.next();
	        
	        if (!inputPassword.equals(password)) {
	            System.out.println("Incorrect Password! Exiting...");
	            return;
	        }
	        
	        while (true) {
	            System.out.println("\n* LIBRARY MANAGEMENT SYSTEM *");
	            System.out.println("******************************");
	            System.out.println("----------------------------");
	            System.out.println("|         MAIN MENU        |");
	            System.out.println("|--------------------------|");
	            System.out.println("|1. Add Book               |");
	            System.out.println("|2. Delete Book            |");
	            System.out.println("|3. Search Book            |");
	            System.out.println("|4. View Books List        |");
	            System.out.println("|5. Edit Book Record       |");
	            System.out.println("|6. Change Password        |");
	            System.out.println("|7. Close Application      |");
	            System.out.println("----------------------------");
	            System.out.print("Enter your choice: ");
	            
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // consume newline
	            
	            switch (choice) {
	                case 1: addBook(); break;
	                case 2: deleteBook(); break;
	                case 3: searchBook(); break;
	                case 4: viewBooks(); break;
	                case 5: editBook(); break;
	                case 6: changePassword(); break;
	                case 7:
	                    System.out.println("Exiting... Please wait.");
	                    try {
	                        Thread.sleep(3000);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                    System.exit(0);
	                    System.out.println("Application closed.");
	                default:
	                    System.out.println("Invalid choice! Try again.");
	            }
	        }
	    }

	    private static void addBook() {
	    	System.out.println("\n----------------------");
	        System.out.println("| SELECT CATEGOIES :  |");
	    	System.out.println("|---------------------|");
	        System.out.println("|1. Computer          |");
	        System.out.println("|2. Electronics       |");
	        System.out.println("|3. Electrical        |");
	        System.out.println("|4. Civil             |");
	        System.out.println("|5. Mechanical        |");
	        System.out.println("|6. Architecture      |");
	        System.out.println("|7. Back to main menu |");
	        System.out.println("----------------------");
	        System.out.print("Enter category number: ");
	        int categoryChoice = scanner.nextInt();
	        scanner.nextLine(); 
	        
	        if (categoryChoice == 7) return;
	        String category = switch (categoryChoice) {
	            case 1 -> "Computer";
	            case 2 -> "Electronics";
	            case 3 -> "Electrical";
	            case 4 -> "Civil";
	            case 5 -> "Mechanical";
	            case 6 -> "Architecture";
	            default -> "Invalid Choices";
	        };
	        
	        System.out.print("Enter Book ID: ");
	        int id = scanner.nextInt();
	        scanner.nextLine();
	        System.out.print("Enter Book Name: ");
	        String bookname = scanner.nextLine();
	        System.out.print("Enter Author: ");
	        String author = scanner.nextLine();
	        System.out.print("Enter Quantity: ");
	        int quantity = scanner.nextInt();
	        System.out.print("Enter Price: ");
	        int price = scanner.nextInt();

	        Book book = new Book(id, bookname, author, category , quantity, price);
	        books.add(book);
	        bookSet.add(book);
	        System.out.println("Book added successfully!");
	    }

	    private static void deleteBook() {
	        System.out.print("Enter Book ID to delete: ");
	        int id = scanner.nextInt();
	        
	        boolean removed = books.removeIf(book -> book.id == id);
	        bookSet.removeIf(book -> book.id == id);
	        
	        if (removed) {
	            System.out.println("Book deleted successfully!");
	        } else {
	            System.out.println("Book not found!");
	        }
	    }

	    private static void searchBook() {
	        System.out.print("Enter BookName or Author to search: ");
	        String keyword = scanner.nextLine().toLowerCase();
	        
	        for (Book book : bookSet) {
	            if (book.bookName.toLowerCase().contains(keyword) || book.author.toLowerCase().contains(keyword)) {
	                System.out.println(book);
	            }
	        }
	    }

	    private static void viewBooks() {
	        if (books.isEmpty()) {
	            System.out.println("No books found!");
	        } else {
	            books.forEach(System.out::println);
	        }
	    }
	    
	 
	    private static void editBook() {
	        System.out.print("Enter Book ID to edit: ");
	        int id = scanner.nextInt();
	        scanner.nextLine();
	        
	        for (Book book : books) {
	            if (book.id == id) {
	                System.out.print("Enter new Book Name: ");
	                book.bookName = scanner.nextLine();
	                System.out.print("Enter new Author: ");
	                book.author = scanner.nextLine();
	                System.out.print("Enter new Category: ");
	                book.category = scanner.nextLine();
	                System.out.print("Enter Quantity: ");
	    	        book.quantity = scanner.nextInt();
	    	        System.out.print("Enter Price: ");
	    	        book.price = scanner.nextInt();
	                System.out.println("Book details updated successfully!");
	                return;
	            }
	        }
	        System.out.println("Book not found!");
	    }

	    private static void changePassword() {
	        System.out.print("Enter Old Password: ");
	        String oldPass = scanner.next();
	        
	        if (!oldPass.equals(password)) {
	            System.out.println("Incorrect old password!");
	            return;
	        }
	        
	        System.out.print("Enter New Password: ");
	        password = scanner.next();
	        System.out.println("Password changed successfully!");
	    }
}
