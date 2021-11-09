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

import com.connection.DBConnection;

@WebServlet("/CheckStatusController")
public class CheckStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CheckStatusController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String groupno=request.getParameter("groupno");
		
		Connection con = DBConnection.getConnection();
		String sql = "select guide_status from projects_data where groupno='"+groupno+"'";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				String status=rs.getString(1);
				
				if(status.equalsIgnoreCase("accept"))
				{
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Accepted')");
					out.println("location='CheckProjectStatus.jsp';");
					out.println("</script>");
				}
				else
				{
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Not Accepted')");
					out.println("location='CheckProjectStatus.jsp';");
					out.println("</script>");
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
