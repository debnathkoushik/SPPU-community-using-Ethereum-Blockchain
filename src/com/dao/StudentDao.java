package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.GroupDetailsBean;
import com.bean.StaffBean;
import com.bean.StudentBean;
import com.bean.UploadBean;


public interface StudentDao {
	
	public boolean InsertStudent(StudentBean studentbean);
	
	public StudentBean CheckStudent(String email,String password);
	
	public boolean availableStudent(StudentBean studentbean);
	
	public UploadBean VerifyTitle(String branch,String domain);
	
	public ArrayList<StaffBean> getStaffNames() throws SQLException;
	
	public StudentBean SelectStudent(String email);
	
	public ResultSet getfile(String filename); 
	
	public boolean InsertGroupDetails(GroupDetailsBean group);
	
	public boolean availableGroup(GroupDetailsBean bb);
	
	public boolean addNotification(String not);
	public boolean addNotification1(String not);
}
