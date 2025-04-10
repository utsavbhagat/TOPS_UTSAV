//o Create a stored procedure in MySQL with IN and OUT parameters (e.g., a procedurethat takes an employee ID as input and returns the employee's full name as output).
//o Write a Java program that uses CallableStatement to call this stored procedure.
//o Demonstrate how to pass IN parameters and retrieve OUT parameters.

package Module_2_JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;


public class P11_1_StoredPocedure {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/java_module2_assigment";
        String user = "root"; 
        String password = "";
        
        int emp_id = 101;
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
        	String sql = "{call GetEmployeeFullName(?, ?)}"; 
            
            try (CallableStatement stmt = conn.prepareCall(sql)) {

            	stmt.setInt(1, emp_id);

                stmt.registerOutParameter(2, Types.VARCHAR); 

                stmt.execute();
                
                String fullName = stmt.getString(2);

                if (fullName == null) {
                    fullName = "Not Found";
                }

                System.out.println("Employee Full Name: " + fullName);
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
