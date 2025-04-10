//14.Use a SELECT query to display this metadata for a specific table.

package Module_2_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class P08_2_SELECT_Query_DATABSEMETADATA_SpecficTable {
	 public static void main(String[] args) {
	      
	        String url = "jdbc:mysql://localhost:3306/java_module2_assigment"; 
	        String username = "root";  
	        String password = "";      

	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        try {
	            // Step 1: Connect to the database
	            conn = DriverManager.getConnection(url, username, password);
	            System.out.println("Connected to the database!");

	            // Step 2: Execute a SELECT query (replace "users" with your table name)
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery("SELECT * FROM users LIMIT 1"); // Fetch one row to get metadata

	            // Step 3: Get metadata of the result set
	            ResultSetMetaData metaData = rs.getMetaData();

	            // Step 4: Get column count
	            int columnCount = metaData.getColumnCount();
	            System.out.println("Number of columns: " + columnCount);

	            // Step 5: Display column names and types
	            for (int i = 1; i <= columnCount; i++) {
	                String columnName = metaData.getColumnName(i);  // Get column name
	                String columnType = metaData.getColumnTypeName(i);  // Get column type
	                System.out.println("Column " + i + ": " + columnName + " (Type: " + columnType + ")");
	            }

	        } catch (SQLException e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            // Step 6: Close resources
	            try {
	                if (rs != null) rs.close();
	                if (stmt != null) stmt.close();
	                if (conn != null) conn.close();
	                System.out.println("Connection closed.");
	            } catch (SQLException e) {
	                System.out.println("Error closing resources: " + e.getMessage());
	            }
	        }
	    }
}
