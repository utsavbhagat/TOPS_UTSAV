//7.Modify the program to use PreparedStatement for parameterized queries.
package Module_2_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class P04_2_PreparedStatement {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/java_module2_assigment";  
        String username = "root";  
        String password = "";      
        
        try {
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to Database");
			

            // 1. Insert Data
            String insertSql = "INSERT INTO users (name,contact, email) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setString(1, "Himanshu");  
            insertStmt.setLong(2, 635346472);
            insertStmt.setString(3, "himanshu@example.com");  
            insertStmt.executeUpdate(); 
            System.out.println("Inserted data into 'users' table.");

            // 2. Update Data
            String updateSql = "UPDATE users SET name = ? WHERE id = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setString(1, "Himanshu Rajpurohit");  
            updateStmt.setInt(2, 4);  
            updateStmt.executeUpdate();  
            System.out.println("Updated data in 'users' table.");

            // 3. Select Data
            String selectSql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setInt(1, 4);  // Set ID for selection
            ResultSet rs = selectStmt.executeQuery();  // Execute the select query
            while (rs.next()) {
                // Print selected data
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Email: " + rs.getString("email"));
            }

            // 4. Delete Data
            String deleteSql = "DELETE FROM users WHERE id = ?";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
            deleteStmt.setInt(1, 1);  
            deleteStmt.executeUpdate();  
            System.out.println("Deleted data from 'users' table.");

            conn.close();
            System.out.println("Connection closed.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
