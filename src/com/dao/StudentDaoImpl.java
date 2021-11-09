package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.GroupDetailsBean;
import com.bean.StaffBean;
import com.bean.StudentBean;
import com.bean.UploadBean;
import com.connection.DBConnection;

public class StudentDaoImpl implements StudentDao{

	boolean flag=false;
	String sql;
	PreparedStatement pm;
	ResultSet rs;
	@Override
	public boolean InsertStudent(StudentBean studentbean) {
		
		String sql="insert into studentreg(name,contactno,address,email,password,gender,branch,year,prnno) values (?,?,?,?,?,?,?,?,?)";
		Connection con=DBConnection.getConnection();
		
		 try {
			pm=con.prepareStatement(sql);
			
			pm.setString(1, studentbean.getName());
			pm.setString(2, studentbean.getContactno());
			pm.setString(3, studentbean.getAddress());
			pm.setString(4, studentbean.getEmail());
			pm.setString(5, studentbean.getPassword());
			pm.setString(6, studentbean.getGender());
			pm.setString(7, studentbean.getBranch());
			pm.setString(8, studentbean.getYear());
			pm.setString(9, studentbean.getPrnno());
			
            int index=pm.executeUpdate();
			
			if(index>0)
			{
				System.out.println("enter into the database");
				flag=true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public StudentBean CheckStudent(String email, String password) {
		
		StudentBean bean=new StudentBean();
		
        sql="select * from studentreg where email='"+email+"' and password='"+password+"'";
		
		Connection con=DBConnection.getConnection();
		
		try {
			pm=con.prepareStatement(sql);
			rs=pm.executeQuery();
			
			while(rs.next())
			{
				bean.setName(rs.getString(2));
				bean.setContactno(rs.getString(3));
				bean.setAddress(rs.getString(4));
				bean.setEmail(rs.getString(5));
				bean.setPassword(rs.getString(6));
				bean.setGender(rs.getString(7));
				bean.setBranch(rs.getString(8));
				bean.setYear(rs.getString(9));
				bean.setPrnno(rs.getString(10));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public boolean availableStudent(StudentBean studentbean) {
		
		String sql="select * from studentreg where email='"+studentbean.getEmail()+"'";
		
		try {
			Statement st=DBConnection.getConnection().createStatement();
			rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return flag;
	}

	@Override
	public ArrayList<StaffBean> getStaffNames() throws SQLException {
		
		String sql="select name from staffreg";
		
		Connection con=DBConnection.getConnection();
		
		ArrayList<StaffBean> stafflist=new ArrayList<StaffBean>();
		
		Statement st=con.createStatement();
		
		rs=st.executeQuery(sql);
		
		while(rs.next())
		{
			StaffBean staff=new StaffBean();
			staff.setName(rs.getString(1));
			
			stafflist.add(staff);
		}
		return stafflist;
	}

	@Override
	public UploadBean VerifyTitle(String branch, String domain) {
		
		String sql="select * from projects_data where branch='"+branch+"' and domain='"+domain+"'";
		
		UploadBean verify=new UploadBean();
		
		Connection con=DBConnection.getConnection();
		
		try {
			pm=con.prepareStatement(sql);
			
			rs=pm.executeQuery();
			
			if(rs.next())
			{
				
				verify.setGuidename(rs.getString(2));
				verify.setBranch(rs.getString(3));
				verify.setDomain(rs.getString(4));
				verify.setGroupno(rs.getString(5));
				verify.setTitle(rs.getString(6));
				verify.setIntroduction(rs.getString(7));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return verify;
	}

	@Override
	public StudentBean SelectStudent(String email) {
		
		StudentBean user = new StudentBean();
			String sql = "Select * from studentreg where email ='"+email+"'";
			try {
				Statement stmt = DBConnection.getConnection().createStatement();
				 rs = stmt.executeQuery(sql);
				if(rs.next()){
					
					   user.setName(rs.getString(2));
					   user.setContactno(rs.getString(3));
					   user.setAddress(rs.getString(4));
		               user.setEmail(rs.getString(5));
		               user.setPassword(rs.getString(6));
		               user.setGender(rs.getString(7));
		               user.setBranch(rs.getString(8));
		               user.setYear(rs.getString(9));
		               user.setPrnno(rs.getString(10));
						
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return user;
		
	}
	
	public ResultSet getfile(String filename) 
	{
	try
	{
		Connection con=DBConnection.getConnection();
		Statement stmt = DBConnection.getConnection().createStatement();
			rs=stmt.executeQuery("select * from projects_data where title='"+filename+"'");	
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public boolean InsertGroupDetails(GroupDetailsBean group) {
		
		String sql="insert into group_details(groupno,year,guide,group_member1,group_member2,group_member3,group_member4) values (?,?,?,?,?,?,?)";
		Connection con=DBConnection.getConnection();
		
		 try {
			pm=con.prepareStatement(sql);
			
			pm.setString(1, group.getGroupno());
			pm.setString(2, group.getYear());
			pm.setString(3, group.getGuide());
			pm.setString(4, group.getGroup1());
			pm.setString(5, group.getGroup2());
			pm.setString(6, group.getGroup3());
			pm.setString(7, group.getGroup4());
			
			
            int index=pm.executeUpdate();
			
			if(index>0)
			{
				System.out.println("enter into the database");
				flag=true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean availableGroup(GroupDetailsBean bb) {
String sql="select * from group_details where groupno='"+bb.getGroupno()+"'";
		
		try {
			Statement st=DBConnection.getConnection().createStatement();
			rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return flag;
	}

	@Override
	public boolean addNotification(String not) {
		
		String sql="insert into add_stud(not) values (?)";
		Connection con=DBConnection.getConnection();
		
		 try {
			pm=con.prepareStatement(sql);
			
			pm.setString(1, not);
			
			
            int index=pm.executeUpdate();
			
			if(index>0)
			{
				System.out.println("enter into the database");
				flag=true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean addNotification1(String not) {
		
		String sql="insert into add_stud1 values(null, ?)";
		Connection con=DBConnection.getConnection();
		
		 try {
			pm=con.prepareStatement(sql);
			
			pm.setString(1, not);
			
			
            int index=pm.executeUpdate();
			
			if(index>0)
			{
				System.out.println("enter into the database");
				flag=true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}


}
