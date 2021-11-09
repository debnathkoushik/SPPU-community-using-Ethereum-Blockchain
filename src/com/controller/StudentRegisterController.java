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
import com.bean.StudentBean;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;

@WebServlet("/StudentRegisterController")
public class StudentRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentRegisterController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String contactno=request.getParameter("contactno");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String branch=request.getParameter("branch");
		String year=request.getParameter("year");
		String prnno=request.getParameter("prnno");
		
		StudentBean studentbean=new StudentBean();
		
		studentbean.setName(name);
		studentbean.setContactno(contactno);
		studentbean.setAddress(address);
		studentbean.setEmail(email);
		studentbean.setPassword(password);
		studentbean.setGender(gender);
		studentbean.setBranch(branch);
		studentbean.setYear(year);
		studentbean.setPrnno(prnno);
		
		StudentDao dao=new StudentDaoImpl();	
		
		MD5 md5=new MD5();
		String hashvalue=md5.generate(name);
		String filename=name+".txt";
	      File myObj = new File("E:\\Nodes\\Students\\"+filename+hashvalue);
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	      
	      FileWriter myWriter = new FileWriter("E:\\Nodes\\Students\\"+filename+hashvalue);
	      myWriter.write("Students Details-"+"Name:"+name+",Address:"+address+",Email:"+email+",Mobile No:"+contactno+",Branch:"+branch+",prnno:"+prnno);
	      myWriter.close();
	      
	      Encryptor bfe=new Encryptor();
			
			try {
				
				bfe.encrypt("E:\\Nodes\\Students\\"+filename+hashvalue);
				
				  
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		
		if(dao.availableStudent(studentbean))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Student is already available');");
			out.println("location='Register.jsp';");
			out.println("</script>");
			System.out.println("Student is already available");
		}
		else
		{
			if(dao.InsertStudent(studentbean))
			{
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Registration Successful..');");
				out.println("location='StudentLogin.jsp';");
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
