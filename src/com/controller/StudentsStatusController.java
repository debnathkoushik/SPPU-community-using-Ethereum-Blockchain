package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StaffDao;
import com.dao.StaffDaoImpl;

@WebServlet("/StudentsStatusController")
public class StudentsStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StudentsStatusController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		//String id=request.getParameter("id");
		String groupno=request.getParameter("groupno");
		String guide_status=request.getParameter("guide_status");
		
		StaffDao dao=new StaffDaoImpl();
		
		if(dao.UpdateStudentStatus(groupno, guide_status))
		{
			ResultSet rs=dao.SelectStudentData();
			if(rs!= null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("listUsers", rs);
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Student Request updated successfully');");
				out.println("location='ViewStudentRequest.jsp';");
				out.println("</script>");
			}
			
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Student Request not updated');");
				out.println("location='ViewStudentRequest.jsp';");
				out.println("</script>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
