package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.StaffBean;
import com.dao.StaffDao;
import com.dao.StaffDaoImpl;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;


@WebServlet("/StaffLoginController")
public class StaffLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StaffLoginController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		StaffDao dao=new StaffDaoImpl();
		StaffBean bean=new StaffBean();
		bean=dao.CheckStaff(email, password);
		if((bean.getEmail()!=null && bean.getEmail()!="") && (bean.getPassword()!=null && bean.getPassword()!=""))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login Successful')");
			out.println("location='StaffView.jsp';");
			out.println("</script>");
			out.print("welcome"+email);
			
			HttpSession session=request.getSession();  
			 session.setAttribute("staff",bean.getName()); 
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login Unsuccessful')");
			out.println("location='Staff.jsp';");
			out.println("</script>");
			
		}
	}

}
