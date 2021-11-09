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

import com.algorithm.StringSimilarity;
import com.bean.UploadBean;
import com.connection.DBConnection;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;

@WebServlet("/VerifyTitleController")
public class VerifyTitleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
    public VerifyTitleController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		UploadBean bean=new UploadBean();
		
		Double Value=0.0;
		Double Value1=0.0;
		String databaseTitle=null,dt=null;
		String databaseAbstract=null,da=null;
		String branch=request.getParameter("branch");
		String domain=request.getParameter("domain");
		String title=request.getParameter("title");
		String introduction=request.getParameter("abstract");
		
		
        String sql="select * from projects_data";
		
		UploadBean verify=new UploadBean();
		
		Connection con=DBConnection.getConnection();
		
		try {
			PreparedStatement pm=con.prepareStatement(sql);
			
			ResultSet rs=pm.executeQuery();
			
			while(rs.next())
			{
			databaseTitle=rs.getString(6);
			
			System.out.println("DataBase Titles:"+databaseTitle);
			
			databaseAbstract=rs.getString(7);
			
			System.out.println("Database Abstract:"+databaseAbstract);	
			
			String titleValue=StringSimilarity.printSimilarity(databaseTitle, title);
			
			Value=Double.parseDouble(titleValue);
			
			String AbstarctValue=StringSimilarity.printSimilarity(databaseAbstract, introduction);
			
			Value1=Double.parseDouble(AbstarctValue);
			
			if( Value>=0.90 && Value1>=0.90)
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Title and Abstract Exactly Match');");
				out.println("location='VerifyTitle.jsp';");
				out.println("</script>");
			}
			
			
			}
			
			System.out.println(" all DataBase Titles:"+dt);
			System.out.println(" all Database Abstract:"+dt);
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		String titleValue=StringSimilarity.printSimilarity(databaseTitle, title);
		
		Value=Double.parseDouble(titleValue);
		
		String AbstarctValue=StringSimilarity.printSimilarity(databaseAbstract, introduction);
		
		Value1=Double.parseDouble(AbstarctValue);
		
	
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Unique Title and Abstract ');");
			out.println("location='VerifyTitle.jsp';");
			out.println("</script>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
