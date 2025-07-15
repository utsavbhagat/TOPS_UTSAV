package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assesment2_session_management", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
