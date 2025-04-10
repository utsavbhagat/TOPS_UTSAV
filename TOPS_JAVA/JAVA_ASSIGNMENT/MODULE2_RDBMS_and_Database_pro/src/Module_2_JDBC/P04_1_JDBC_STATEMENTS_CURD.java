//6.Create a program that inserts, updates, selects, and deletes data using Statement.

package Module_2_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class P04_1_JDBC_STATEMENTS_CURD {
	public static void main(String[]args) {
		String url = "jdbc:mysql://localhost:3306/java_module2_assigment";
		String username = "root";
		String password = "";
		
		try {
//			Establish Connection
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connect to the Database");
			
//			create statement
			Statement stmt = conn.createStatement();
			
//			1. Insert Data
			String insertsql = "INSERT INTO users (name,contact,email) VALUES ('miku',9097039388,'mikukumar@gmail.com')";
			stmt.executeUpdate(insertsql);
			System.out.println("Data Inserted in users table");
			
//			2. Update Data
			String updateSql = "UPDATE users SET name = 'Miku Kumar' where id = 3";
			stmt.executeUpdate(updateSql);
			System.out.println("Updated In users table .");
			
//			3. Select Data
			String selectsql = "SELECT * FROM users WHERE id = 1";
			ResultSet rs = stmt.executeQuery(selectsql);
			while (rs.next()) {
				System.out.println("ID: "+ rs.getInt("id") + ", Name: "+ rs.getString("name")+ ", Contact: "+rs.getLong("contact")+" , Email: "+rs.getString("email") );
			}
//			4. Delete Data
			String deleteSql = "DELETE FROM users WHERE id = 2";
            stmt.executeUpdate(deleteSql);
            System.out.println("Deleted data from the 'users' table.");

            // Close the connection
            conn.close();
            System.out.println("Connection closed.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
