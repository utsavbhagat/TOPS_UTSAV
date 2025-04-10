//16.Implement CRUD operations (Insert, Update, Select, Delete) using JDBC and MySQL.

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

class DataNotFoundd {
    JLabel l1;

    public DataNotFoundd() {
        JFrame fr = new JFrame("Alert");
        fr.setVisible(true);
        fr.setLayout(null);
        fr.setSize(300, 200);

        l1 = new JLabel("Data not found");
        l1.setBounds(50, 50, 120, 20);
        fr.add(l1);
    }
}


class swing1 implements ActionListener{
	JButton b1,b2,b3,b4;
	JTextField t1,t2,t3,t4;
	JLabel l1,l2,l3,l4;
	
	public swing1() {
		JFrame fr = new JFrame("My Swing Example");
        fr.setVisible(true);
        fr.setLayout(null);
        fr.setSize(700, 400);

        l1 = new JLabel("ID : ");
        l1.setBounds(100, 100, 120, 20);
        fr.add(l1);

        l2 = new JLabel("First Name : ");
        l2.setBounds(100, 130, 120, 20);
        fr.add(l2);

        l3 = new JLabel("Last Name : ");
        l3.setBounds(100, 160, 120, 20);
        fr.add(l3);

        l4 = new JLabel("Email : ");
        l4.setBounds(100, 190, 120, 20);
        fr.add(l4);

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

        b1 = new JButton("Insert");
        b1.setBounds(100, 240, 120, 20);
        fr.add(b1);

        // Changed 'Search' button to 'Select' button
        b2 = new JButton("Select");
        b2.setBounds(250, 240, 120, 20);
        fr.add(b2);

        b3 = new JButton("Update");
        b3.setBounds(100, 270, 120, 20);
        fr.add(b3);

        b4 = new JButton("Delete");
        b4.setBounds(250, 270, 120, 20);
        fr.add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
	}
	public static Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_module2_assigment", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
//		Insert Button
		if (e.getSource() == b1) {
			System.out.println("Insert button clicked");
			int id = Integer.parseInt(t1.getText());
			String firstName = t2.getText();
			String lastName = t3.getText();
			String email = t4.getText();
			System.out.println(id +" "+ firstName + " " + lastName + " " + email);
			try {
				Connection conn = swing1.createConnection();
				String sql = "INSERT INTO swinggui(id, first_name, last_name, email) VALUES(?, ?, ?, ?)";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
				pst.setString(2, firstName);
				pst.setString(3, lastName);
                pst.setString(4, email);
                pst.executeUpdate();
                System.out.println("Data inserted");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
		
//		Select button for search
		else if(e.getSource()==b2){
			System.out.println("Select button clicked");
			int id = Integer.parseInt(t1.getText());
			            
            try {
				Connection conn = swing1.createConnection();
				String sql = "SELECT * FROM swinggui WHERE id =?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					t1.setText(String.valueOf(rs.getInt("id")));
					t2.setText(rs.getString("first_name"));
					t3.setText(rs.getString("last_name"));
                    t4.setText(rs.getString("email"));
				} else {
					System.out.println("Data not found");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    new DataNotFoundd(); // Show alert if no data found
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		// Update button
		else if (e.getSource()==b3) {
			System.out.println("Update button clicked");
			int id = Integer.parseInt(t1.getText());
			String firstName = t2.getText();
            String lastName = t3.getText();
            String email = t4.getText();
            
            try {
				Connection conn = swing1.createConnection();
				String sql = "UPDATE swinggui SET first_name=?, last_name=?, email=? WHERE id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, firstName);
				pst.setString(2, lastName);
				pst.setString(3, email);
                pst.setInt(4, id);
                pst.executeUpdate();
                System.out.println("Data updated");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		// Delete button
        else if (e.getSource() == b4) {
            System.out.println("Delete button clicked");
            int id = Integer.parseInt(t1.getText());
            try {
                Connection conn = swing1.createConnection();
                String sql = "DELETE FROM swinggui WHERE id=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                pst.executeUpdate();
                System.out.println("Data deleted");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		
	}
	
}
public class P10_2_Swing_CRUD_OPERATION {
	public static void main(String[] args) {
		new swing1();
	}
}
