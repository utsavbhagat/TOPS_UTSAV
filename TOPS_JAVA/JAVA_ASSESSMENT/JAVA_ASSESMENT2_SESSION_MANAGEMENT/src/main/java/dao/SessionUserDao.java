package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnection;
import model.SessionUser;

public class SessionUserDao {
	public static boolean checkSessionUserEmail(String email) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from session_user_reg where suemail=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void insertUser(SessionUser SesU) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "insert into session_user_reg(sufirstname,sulastname,suemail,sumobile,suaddress,sugender,supassword) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, SesU.getFirstname());
			pst.setString(2, SesU.getLastname());
			pst.setString(3, SesU.getEmail());
			pst.setLong(4, SesU.getContact());
			pst.setString(5, SesU.getAddress());
			pst.setString(6, SesU.getGender());
			pst.setString(7, SesU.getPassword());

			pst.executeUpdate();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionUser SessionUserLogin(SessionUser u) {
		SessionUser SesU = null;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from session_user_reg where suemail=? and supassword=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				SesU = new SessionUser();
				SesU.setSuid(rs.getInt("suid"));
				SesU.setFirstname(rs.getString("sufirstname"));
				SesU.setLastname(rs.getString("sulastname"));
				SesU.setEmail(rs.getString("suemail"));
				SesU.setContact(rs.getLong("sumobile"));
				SesU.setAddress(rs.getString("suaddress"));
				SesU.setGender(rs.getString("sugender"));
				SesU.setPassword(rs.getString("supassword"));

				System.out.println("d in DAO class : " + SesU);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SesU;
	}

	public static void changePassword(int id, String np) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update session_user_reg set supassword=? where suid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("Password updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkOldPassword(int id, String op) {
		boolean flag = false;
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "select * from session_user_reg where supassword=? and suid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, op);
			pst.setInt(2, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void newPassword(String email, String np) {
		try {
			Connection conn = DBConnection.createConnection();
			String sql = "update session_user_reg set supassword=? where suemail=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println(" Session Password updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}