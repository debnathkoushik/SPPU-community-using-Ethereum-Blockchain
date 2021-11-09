package com.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algorithm.Encryptor;
import com.algorithm.MD5;
import com.bean.StaffBean;
import com.dao.StaffDao;
import com.dao.StaffDaoImpl;

@WebServlet("/StaffRegisterController")
public class StaffRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public StaffRegisterController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String name=request.getParameter("name");
			String contactno=request.getParameter("contactno");
			String address=request.getParameter("address");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String gender=request.getParameter("gender");
			String branch=request.getParameter("branch");
			String designation=request.getParameter("designation");
			
			StaffBean staffbean=new StaffBean();
			
			staffbean.setName(name);
			staffbean.setContactno(contactno);
			staffbean.setAddress(address);
			staffbean.setEmail(email);
			staffbean.setPassword(password);
			staffbean.setGender(gender);
			staffbean.setBranch(branch);
			staffbean.setDesignation(designation);
			
			StaffDao dao=new StaffDaoImpl();
			
			MD5 md5=new MD5();
			String hashvalue=md5.generate(name);
			String filename=name+".txt";
		      File myObj = new File("E:\\Nodes\\Staff\\"+filename+hashvalue);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		      
		      FileWriter myWriter = new FileWriter("E:\\Nodes\\Staff\\"+filename+hashvalue);
		      myWriter.write("Staff Details-"+"Name:"+name+",Address:"+address+",Email:"+email+",Mobile No:"+contactno+",Branch:"+branch+",designation:"+designation);
		      myWriter.close();
		      
		      Encryptor bfe=new Encryptor();
				
				try {
					
					bfe.encrypt("E:\\Nodes\\Staff\\"+filename+hashvalue);
					
					  
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			
			if(dao.availableStaff(staffbean))
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Student is already available');");
				out.println("location='RegisterStaff.jsp';");
				out.println("</script>");
				System.out.println("Staff Member is already available");
			}
			else
			{
				if(dao.InsertStaff(staffbean))
				{
					//EmailSend es = new EmailSend();
					//es.sendRegistrationEmail(email);
					
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Registration Successful..');");
					out.println("location='Staff.jsp';");
					out.println("</script>");
					
				}
				else
				{
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Registration Fail..');");
					out.println("location='Register.jsp';");
					out.println("</script>");
				}
			 }
	}

}
