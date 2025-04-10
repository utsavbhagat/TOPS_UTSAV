//12.Display database name, version, list of tables, and supported SQL features.

package Module_2_JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class P07_2_Database_Detailes {
public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/java_module2_assigment"; 
        String username = "root";  
        String password = "";    

        Connection conn = null;

        try {
         
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

           
            DatabaseMetaData metaData = conn.getMetaData();

           
            System.out.println("Database Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Version: " + metaData.getDatabaseProductVersion());

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close(); 
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
