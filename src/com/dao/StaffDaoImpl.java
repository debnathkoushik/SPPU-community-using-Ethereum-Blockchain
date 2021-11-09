package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.StaffBean;
import com.connection.DBConnection;

public class StaffDaoImpl implements StaffDao {

	boolean flag = false;
	String sql;
	PreparedStatement pm;
	ResultSet rs;

	@Override
	public boolean InsertStaff(StaffBean staffbean) {

		String sql = "insert into staffreg(name,contactno,address,email,password,gender,branch,designation) values (?,?,?,?,?,?,?,?)";
		Connection con = DBConnection.getConnection();

		try {
			pm = con.prepareStatement(sql);

			pm.setString(1, staffbean.getName());
			pm.setString(2, staffbean.getContactno());
			pm.setString(3, staffbean.getAddress());
			pm.setString(4, staffbean.getEmail());
			pm.setString(5, staffbean.getPassword());
			pm.setString(6, staffbean.getGender());
			pm.setString(7, staffbean.getBranch());
			pm.setString(8, staffbean.getDesignation());

			int index = pm.executeUpdate();

			if (index > 0) {
				System.out.println("enter into the database");
				flag = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public StaffBean CheckStaff(String email, String password) {

		StaffBean bean = new StaffBean();

		sql = "select * from staffreg where email='" + email + "' and password='" + password + "'";

		Connection con = DBConnection.getConnection();

		try {
			pm = con.prepareStatement(sql);

			rs = pm.executeQuery();

			if (rs.next()) {
				bean.setName(rs.getString(2));
				bean.setContactno(rs.getString(3));
				bean.setAddress(rs.getString(4));
				bean.setEmail(rs.getString(5));
				bean.setPassword(rs.getString(6));
				bean.setGender(rs.getString(7));
				bean.setBranch(rs.getString(8));
				bean.setDesignation(rs.getString(9));
			} else {
				flag = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public boolean availableStaff(StaffBean staffbean) {

		String sql = "select * from staffreg where email='" + staffbean.getEmail() + "'";

		try {
			Statement st = DBConnection.getConnection().createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public StaffBean SelectStudent(String email) {

		StaffBean user = new StaffBean();
		String sql = "Select * from staffreg where email ='" + email + "'";
		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {

				user.setName(rs.getString(2));
				user.setContactno(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPassword(rs.getString(6));
				user.setGender(rs.getString(7));
				user.setBranch(rs.getString(8));
				user.setDesignation(rs.getString(9));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean UpdateStudentStatus(String id, String status) {

		if (status.equalsIgnoreCase("Reject"))
			status = "Accept";
		else
			status = "Reject";

		String sql = "update projects_data set guide_status=? where groupno=?";

		try {
			pm = DBConnection.getConnection().prepareStatement(sql);
			pm.setString(1, status);
			pm.setString(2, id);

			int index = pm.executeUpdate();
			if (index > 0) {
				flag = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;

	}

	@Override
	public ResultSet SelectStudentData() {
		ResultSet rs = null;
		String sql = "select * from projects_data";

		try {
			PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;
	}
}
