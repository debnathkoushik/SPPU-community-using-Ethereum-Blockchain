package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.DBConnection;

public class AdminDaoImpl implements AdminDao {
	boolean flag=false;
	String sql;
	PreparedStatement pm;
	ResultSet rs;
	
	@Override
	public boolean CheckAdmin(String email, String password) {
		
     sql=" select * from admin where email=? and password=?";
		
		Connection con=DBConnection.getConnection();
		
		try {
			pm=con.prepareStatement(sql);
			
			pm.setString(1, email);
			pm.setString(2, password);
			
			rs=pm.executeQuery();
			
			if(rs.next())
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}

}
