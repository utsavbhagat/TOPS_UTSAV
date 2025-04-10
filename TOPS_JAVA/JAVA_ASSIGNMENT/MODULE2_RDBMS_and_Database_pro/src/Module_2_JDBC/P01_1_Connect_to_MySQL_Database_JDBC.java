//1.Write a simple Java program to connect to a MySQL database using JDBC.

package Module_2_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class P01_1_Connect_to_MySQL_Database_JDBC {
	public static void main(String[] args) {
        // Replace with your DB details
        String url = "jdbc:mysql://localhost:3306/java_module2_assigment";
        String user = "root";
        String password = "";
        
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load MySQL JDBC Driver 
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver loaded!");

            // Establish the connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");
            
            stmt = conn.createStatement();
            String sql = "INSERT INTO users (id,name,contact,email ) VALUES (1,'UTSAV BHAGAT',9512371008,'bhagatutsav@gmail.com')";
            stmt.executeUpdate(sql);
            System.out.println("Data inserted into 'users' table.");
            
        } catch (Exception e) {
	           
            System.out.println("Connection failed! Check your username, password, and URL.");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
