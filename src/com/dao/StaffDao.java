package com.dao;

import java.sql.ResultSet;

import com.bean.StaffBean;


public interface StaffDao {

	public boolean InsertStaff(StaffBean staffbean);

	public StaffBean CheckStaff(String email, String password);

	public boolean availableStaff(StaffBean staffbean);
	
	public StaffBean SelectStudent(String email);
	
	public boolean UpdateStudentStatus(String id,String status);
	
	public ResultSet SelectStudentData();

}
