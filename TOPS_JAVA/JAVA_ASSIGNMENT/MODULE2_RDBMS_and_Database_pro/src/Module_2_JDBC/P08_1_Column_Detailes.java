//13.Write a program that retrieves and displays column names, types, and count of a
//ResultSet using ResultSetMetaData.package Module_2_JDBC;
package Module_2_JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class P08_1_Column_Detailes {
	public static void main(String[] args) {
	       
        String url = "jdbc:mysql://localhost:3306/java_module2_assigment"; 
        String username = "root";  
        String password = "";   
        

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users"); 
            
            ResultSetMetaData metaData = rs.getMetaData();

            int columnCount = metaData.getColumnCount();
            System.out.println("Number of columns: " + columnCount);

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String columnType = metaData.getColumnTypeName(i);
                System.out.println("Column " + i + ": " + columnName + " (Type: " + columnType + ")");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
