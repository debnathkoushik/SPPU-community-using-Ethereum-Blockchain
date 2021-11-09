package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		AdminBean bean=new AdminBean();
		bean.setEmail(email);
		bean.setPassword(password);
		
		AdminDao dao=new AdminDaoImpl();
		
		if(dao.CheckAdmin(email, password))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login Successfully..');");
			out.println("location='AdminView.jsp';");
			
			HttpSession session=request.getSession();
			session.setAttribute("emailMsg", email);
			
			out.println("</script>");
			
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login Failed..');");
			out.println("location='Admin.jsp';");
			out.println("</script>");
		}
	}

}
