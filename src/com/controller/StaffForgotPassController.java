package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StaffBean;
import com.dao.StaffDao;
import com.dao.StaffDaoImpl;
import com.mail.ForgotPassword;

@WebServlet("/StaffForgotPassController")
public class StaffForgotPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public StaffForgotPassController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		
		StaffDao dao=new StaffDaoImpl();
		
		StaffBean bean=new StaffBean();
		
		bean=dao.SelectStudent(email);
		
		if(bean.getPassword()!=null && bean.getPassword()!=""){
			ForgotPassword forgotPass=new ForgotPassword();
			forgotPass.forgotPassEmailSend(email, bean.getPassword());
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password Send Successfully');");
			out.println("location='Staff.jsp';");
			out.println("</script>");
			
		}else{
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password not send');");
			out.println("location='ForgotPass.jsp';");
			out.println("</script>");
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
