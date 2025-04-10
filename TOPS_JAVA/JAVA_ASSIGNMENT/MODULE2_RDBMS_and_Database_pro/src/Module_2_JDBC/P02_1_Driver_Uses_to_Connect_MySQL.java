//3.Identify which driver your Java program uses to connect to MySQL.
package Module_2_JDBC;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;



public class P02_1_Driver_Uses_to_Connect_MySQL {
	public static void main(String[] args) {
        // Load the driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded: com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }

        // List all registered JDBC drivers
        System.out.println("\nRegistered JDBC Drivers:");
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            System.out.println("→ " + driver.getClass().getName());
        }
    }
}
