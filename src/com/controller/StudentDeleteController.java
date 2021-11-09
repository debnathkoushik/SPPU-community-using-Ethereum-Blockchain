package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.DBConnection;

@WebServlet("/StudentDeleteController")
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StudentDeleteController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		
		String sql="delete from studentreg where id='"+id+"'";
		Connection con=DBConnection.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			int index=ps.executeUpdate();
			
			if(index>0)
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Delete successfully');");
				out.println("location='ViewStudentsData.jsp';");
				out.println("</script>");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('not Deleted');");
				out.println("location='ViewStudentsData.jsp';");
				out.println("</script>");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
