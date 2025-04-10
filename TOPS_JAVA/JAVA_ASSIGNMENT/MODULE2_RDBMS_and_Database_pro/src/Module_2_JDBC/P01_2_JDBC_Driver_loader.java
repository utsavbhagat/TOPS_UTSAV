//2.Demonstrate the process of loading a JDBC driver and establishing a connection.
package Module_2_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class P01_2_JDBC_Driver_loader {
	public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_module2_assigment";  
        String username = "root";  
        String password = "";  

        Connection conn = null;

        try {
         
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver loaded!");

            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected to the database!");

            String sql = "INSERT INTO users (name,contact, email) VALUES (?, ?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
//            stmt.setInt(1, 1);  
            stmt.setString(1, "utsav");
            stmt.setLong(2, 123456789);
            stmt.setString(3, "bhagatutsav2000@gmail.com");  
            
            stmt.executeUpdate();
            System.out.println("Data inserted into the 'users' table.");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
        } catch (SQLException e) {
            System.out.println("Connection failed! Check your username, password, and URL.");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                System.out.println("Error closing the connection.");
                e.printStackTrace();
            }
        }
    }
}
