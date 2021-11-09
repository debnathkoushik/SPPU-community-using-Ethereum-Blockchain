package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DBConnection;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.mail.SendNotification;

@WebServlet("/StudentNotificationController")
public class StudentNotificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StudentNotificationController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        PrintWriter out=response.getWriter();
        HttpSession ss=request.getSession();
		
		String notification=request.getParameter("student");
		
		StudentDao dao=new StudentDaoImpl();	
		dao.addNotification(notification);
		
		String sql="select * from studentreg";
		
		Connection con=DBConnection.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				String email=rs.getString(5);
				
				SendNotification sen=new SendNotification();
				sen.Notification(email, notification);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Notification Send Successfully')");
		out.println("location='Notification.jsp';");
		out.println("</script>");  
		ss.setAttribute("stud_note", notification);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
