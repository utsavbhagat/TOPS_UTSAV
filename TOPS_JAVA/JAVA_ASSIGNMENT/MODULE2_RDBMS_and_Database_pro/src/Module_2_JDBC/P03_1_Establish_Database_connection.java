package Module_2_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class P03_1_Establish_Database_connection {
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_module2_assigment", "root", "");
			System.out.println("Successfully Connected to Database");
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
