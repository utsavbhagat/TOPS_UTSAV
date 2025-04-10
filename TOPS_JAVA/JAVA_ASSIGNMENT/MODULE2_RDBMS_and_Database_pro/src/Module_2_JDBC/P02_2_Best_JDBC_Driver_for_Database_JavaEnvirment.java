package Module_2_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class P02_2_Best_JDBC_Driver_for_Database_JavaEnvirment {
	 public static void main(String[] args) {
	      
	        String url = "jdbc:mysql://localhost:3306/java_module2_assigment?useSSL=true&serverTimezone=UTC";
	        String username = "root";
	        String password = "";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            Connection connection = DriverManager.getConnection(url, username, password);

	            if (connection != null) {
	                System.out.println("Connection to MySQL database successful!");
	            }

	        } catch (ClassNotFoundException e) {
	            System.err.println("JDBC Driver not found.");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.err.println("SQL Exception: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
}
