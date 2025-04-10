//11.Write a program that retrieves and displays metadata information about yourdatabase using DatabaseMetaData.
package Module_2_JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class P07_1_Retrives_and_display_DatabaseMetadata {
	public static void main(String[] args) {
	     
        String url = "jdbc:mysql://localhost:3306/java_module2_assigment"; 
        String username = "root";
        String password = "";      

        Connection conn = null;

        try {
            
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            DatabaseMetaData dbMetaData = conn.getMetaData();

            System.out.println("Database Product Name: " + dbMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbMetaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dbMetaData.getDriverName());
            System.out.println("Driver Version: " + dbMetaData.getDriverVersion());

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
