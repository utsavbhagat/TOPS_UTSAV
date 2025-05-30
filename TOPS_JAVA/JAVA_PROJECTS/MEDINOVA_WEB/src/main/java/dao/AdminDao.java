package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.Appointment;
import model.Doctor;

public class AdminDao {
	public static List<Doctor> getAllDoctors(){
		List<Doctor> list = new ArrayList<Doctor>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from doctor";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Doctor d = new Doctor();
				d.setDid(rs.getInt("did"));
				d.setImage(rs.getString("image"));
				d.setName(rs.getString("name"));
				d.setContact(rs.getLong("contact"));
				d.setAddress(rs.getString("address"));
				d.setSpecialization(rs.getString("specialization"));
				d.setWork_address(rs.getString("w_address"));
				d.setEmail(rs.getString("email"));
				System.out.println("d in DAO class : " + d);
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Appointment> getAllAppoinements(){
		List<Appointment> list = new ArrayList<Appointment>();
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from appointment";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Appointment a = new Appointment();
				a.setAid(rs.getInt("aid"));
				a.setPid(rs.getInt("pid"));
//				
				a.setDate(rs.getDate("date"));
				a.setStatus(rs.getString("status"));
				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
