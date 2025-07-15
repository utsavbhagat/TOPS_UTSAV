package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LibraryManagementSystem {
	private static final Scanner scanner = new Scanner(System.in);
	 private static final String url = "jdbc:mysql://localhost:3306/java_assesment1_library";
	 private static final String user = "root";
	 private static String password = "";
	    
	    public static void main(String[] args) {
	    	try (Connection conn = DriverManager.getConnection(url, user, password)){
	    		System.out.println(conn);
			if(!authenticate(conn)) return;
			
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
	                case 1: addBook(conn); break;
	                case 2: deleteBook(conn); break;
	                case 3: searchBook(conn); break;
	                case 4: viewBooks(conn); break;
	                case 5: editBook(conn); break;
	                case 6: changePassword(conn); break;
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
	       } catch (Exception e) {
			e.printStackTrace();
	       }     
	    }
	    private static boolean authenticate(Connection conn) throws SQLException {
	    	System.out.print("Enter Email: ");
	        String inputEmail = scanner.next();
	        System.out.print("Enter Password: ");
	        String inputPassword = scanner.next();

	        String query = "SELECT * FROM library_users WHERE email = ?";
	        try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        	stmt.setString(1, inputEmail);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	            	String storedEmail = rs.getString("email");
	                String storedPassword = rs.getString("password");
	                if (storedPassword.equals(inputPassword) && storedEmail.equals(inputEmail)) {
	                    return true;
	                }
	            }
	        }
	        System.out.println("Incorrect Password! Exiting...");
	        return false;
	    }

	    private static void addBook(Connection conn) throws SQLException{
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
	        
	        if (categoryChoice == 7) {
	        	System.out.println("Back to main menu");
	        	return;
	        }
	        String category = switch (categoryChoice) {
	            case 1 -> "Computer";
	            case 2 -> "Electronics";
	            case 3 -> "Electrical";
	            case 4 -> "Civil";
	            case 5 -> "Mechanical";
	            case 6 -> "Architecture";
	            default -> "Invalid Choices";
	        };
	        
//	        System.out.print("Enter Book ID: ");
//	        int id = scanner.nextInt();`
//	        scanner.nextLine();
	        System.out.print("Enter Book Name: ");
	        String bookname = scanner.nextLine();
	        System.out.print("Enter Author: ");
	        String author = scanner.nextLine();
	        System.out.print("Enter Quantity: ");
	        int quantity = scanner.nextInt();
	        System.out.print("Enter Price: ");
	        int price = scanner.nextInt();

	        String sql = "INSERT INTO books(category,book_name,book_author,quantity,book_price) VALUES (?,?,?,?,?)";
	        try (PreparedStatement pst = conn.prepareStatement(sql)){
				pst.setString(1,category);
				pst.setString(2,bookname);
				pst.setString(3,author);
				pst.setInt(4,quantity);
				pst.setInt(5,price);
				pst.executeUpdate();
				System.out.println("Book added successfully!");
			}
	        
	    }

	    private static void deleteBook(Connection conn) throws SQLException {
	        System.out.print("Enter Book ID to delete: ");
	        int id = scanner.nextInt();
	        
	        String sql = "DELETE FROM books WHERE book_id = ?";
	        try (PreparedStatement pst = conn.prepareStatement(sql)){
				pst.setInt(1, id);
				int rows = pst.executeUpdate();
				if (rows > 0) System.out.println("Book deleted.");
			}
	    }

	    private static void searchBook(Connection conn) throws SQLException {
	        System.out.print("Enter BookName or Author to search: ");
	        String keyword = scanner.nextLine().toLowerCase();
	        
	        String sql = "SELECT * FROM books WHERE book_name LIKE ? OR book_author LIKE ?";
	        try (PreparedStatement pst = conn.prepareStatement(sql)) {
	            pst.setString(1, "%" + keyword + "%");
	            pst.setString(2, "%" + keyword + "%");
	            ResultSet rs = pst.executeQuery();

	            boolean found = false;
	            while (rs.next()) {
	                printBook(rs);
	                found = true;
	            }
	            if (!found) System.out.println("No matching books found.");
	        }
	    }

	    private static void printBook(ResultSet rs) throws SQLException {
	    	 System.out.println("ID: " + rs.getInt("book_id") +
	                 ", Name: " + rs.getString("book_name") +
	                 ", Author: " + rs.getString("book_author") +
	                 ", Category: " + rs.getString("category") +
	                 ", Quantity: " + rs.getInt("quantity") +
	                 ", Price: $" + rs.getDouble("book_price"));
	     }
		
		private static void viewBooks(Connection conn) throws SQLException {
			String sql = "SELECT * FROM books";
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ResultSet rs = ps.executeQuery();
	            boolean found = false;
	            while (rs.next()) {
	                printBook(rs);
	                found = true;
	            }
	            if (!found) System.out.println("No books found.");
	        }
	    }
	    
	 
	    private static void editBook(Connection conn) throws SQLException {
	        System.out.print("Enter Book ID to edit: ");
	        int id = scanner.nextInt();
	        scanner.nextLine();
	        
	        System.out.print("Enter new Book Name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter new Author: ");
	        String author = scanner.nextLine();
	        System.out.print("Enter new Category: ");
	        String category = scanner.nextLine();
	        System.out.print("Enter Quantity: ");
	        int quantity = scanner.nextInt();
	        System.out.print("Enter Price: ");
	        double price = scanner.nextDouble();

	        String sql = "UPDATE books SET book_name=?, book_author=?, category=?, quantity=?, book_price=? WHERE book_id=?";
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, name);
	            ps.setString(2, author);
	            ps.setString(3, category);
	            ps.setInt(4, quantity);
	            ps.setDouble(5, price);
	            ps.setInt(6, id);

	            int rows = ps.executeUpdate();
	            if (rows > 0) System.out.println("Book updated.");
	            else System.out.println("Book not found.");
	        }
	    }

	    private static void changePassword(Connection conn) throws SQLException {
	        System.out.print("Enter Old Password: ");
	        String oldPass = scanner.next();
	        
	        String checkSql = "SELECT password FROM library_users WHERE user_id=1";
	        try (PreparedStatement check = conn.prepareStatement(checkSql)) {
	            ResultSet rs = check.executeQuery();
	            if (rs.next() && !rs.getString("password").equals(oldPass)) {
	                System.out.println("Incorrect old password!");
	                return;
	            }
	        }
	        
	        System.out.print("Enter New Password: ");
	        String newPass = scanner.next();
	        String updateSql = "UPDATE library_users SET password=? WHERE user_id=1";
	        try (PreparedStatement update = conn.prepareStatement(updateSql)) {
	            update.setString(1, newPass);
	            update.executeUpdate();
	            System.out.println("Password changed.");
	        }
	    }

}
