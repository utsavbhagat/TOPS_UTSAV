package Module_2_JDBC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class DataNotFound {
    JLabel l1;

    public DataNotFound() {
        JFrame fr = new JFrame("Alert");
        fr.setVisible(true);
        fr.setLayout(null);
        fr.setSize(300, 200);

        l1 = new JLabel("Data not found");
        l1.setBounds(50, 50, 120, 20);
        fr.add(l1);
    }
}

class SQL implements ActionListener {
    JButton b1, b2, b3, b4;
    JTextField t1, t2, t3, t4, t5, t6;  
    JLabel l1, l2, l3, l4, l5, l6;

    public SQL() {
        JFrame fr = new JFrame("Employee Management System");
        fr.setVisible(true);
        fr.setLayout(null);
        fr.setSize(700, 500);

        l1 = new JLabel("Employee ID: ");
        l1.setBounds(100, 100, 120, 20);
        fr.add(l1);

        l2 = new JLabel("First Name: ");
        l2.setBounds(100, 130, 120, 20);
        fr.add(l2);

        l3 = new JLabel("Last Name: ");
        l3.setBounds(100, 160, 120, 20);
        fr.add(l3);

        l4 = new JLabel("Hire Date (YYYY-MM-DD): ");
        l4.setBounds(100, 190, 150, 20);
        fr.add(l4);

        l5 = new JLabel("Department: ");
        l5.setBounds(100, 220, 120, 20);
        fr.add(l5);

        l6 = new JLabel("Salary: ");
        l6.setBounds(100, 250, 120, 20);
        fr.add(l6);

        t1 = new JTextField();
        t1.setBounds(180, 100, 120, 20);
        fr.add(t1);

        t2 = new JTextField();
        t2.setBounds(180, 130, 120, 20);
        fr.add(t2);

        t3 = new JTextField();
        t3.setBounds(180, 160, 120, 20);
        fr.add(t3);

        t4 = new JTextField();
        t4.setBounds(180, 190, 120, 20);
        fr.add(t4);

        t5 = new JTextField();
        t5.setBounds(180, 220, 120, 20);
        fr.add(t5);

        t6 = new JTextField();
        t6.setBounds(180, 250, 120, 20);
        fr.add(t6);

        b1 = new JButton("Insert");
        b1.setBounds(100, 290, 120, 20);
        fr.add(b1);

        b2 = new JButton("Select");
        b2.setBounds(250, 290, 120, 20);
        fr.add(b2);

        b3 = new JButton("Update");
        b3.setBounds(100, 320, 120, 20);
        fr.add(b3);

        b4 = new JButton("Delete");
        b4.setBounds(250, 320, 120, 20);
        fr.add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    public static Connection createConnection() {
        Connection conn = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection to database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_module2_assigment", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Insert button
        if (e.getSource() == b1) {
            System.out.println("Insert button clicked");
            int employeeId = Integer.parseInt(t1.getText());
            String firstName = t2.getText();
            String lastName = t3.getText();
            String hireDate = t4.getText();  // Expected format: YYYY-MM-DD
            String department = t5.getText();
            double salary = Double.parseDouble(t6.getText());

            try {
                Connection conn = SQL.createConnection();
                String sql = "INSERT INTO employee(employee_id, first_name, last_name, hire_date, department, salary) VALUES(?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, employeeId);
                pst.setString(2, firstName);
                pst.setString(3, lastName);
                pst.setString(4, hireDate);
                pst.setString(5, department);
                pst.setDouble(6, salary);
                pst.executeUpdate();
                System.out.println("Data inserted successfully");
                // Clear the text fields
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        // Select button
        else if (e.getSource() == b2) {
            System.out.println("Select button clicked");
            int employeeId = Integer.parseInt(t1.getText());

            try {
                Connection conn = SQL.createConnection();
                String sql = "SELECT * FROM employee WHERE employee_id=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, employeeId);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    t1.setText(String.valueOf(rs.getInt("employee_id")));
                    t2.setText(rs.getString("first_name"));
                    t3.setText(rs.getString("last_name"));
                    t4.setText(rs.getString("hire_date"));
                    t5.setText(rs.getString("department"));
                    t6.setText(String.valueOf(rs.getDouble("salary")));
                } else {
                    System.out.println("Data not found");
                    new DataNotFound();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        // Update button
        else if (e.getSource() == b3) {
            System.out.println("Update button clicked");
            int employeeId = Integer.parseInt(t1.getText());
            String firstName = t2.getText();
            String lastName = t3.getText();
            String hireDate = t4.getText();
            String department = t5.getText();
            double salary = Double.parseDouble(t6.getText());

            try {
                Connection conn = SQL.createConnection();
                String sql = "UPDATE employee SET first_name=?, last_name=?, hire_date=?, department=?, salary=? WHERE employee_id=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, firstName);
                pst.setString(2, lastName);
                pst.setString(3, hireDate);
                pst.setString(4, department);
                pst.setDouble(5, salary);
                pst.setInt(6, employeeId);
                pst.executeUpdate();
                System.out.println("Data updated successfully");
                // Clear the text fields
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        // Delete button
        else if (e.getSource() == b4) {
            System.out.println("Delete button clicked");
            int employeeId = Integer.parseInt(t1.getText());

            try {
                Connection conn = SQL.createConnection();
                String sql = "DELETE FROM employee WHERE employee_id=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, employeeId);
                pst.executeUpdate();
                System.out.println("Data deleted successfully");
             
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
public class P09_2_JDBC_SQL_Quereis {
	 public static void main(String[] args) {
	        new SQL();
	    }
}
