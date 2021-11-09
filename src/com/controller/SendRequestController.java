package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.DBConnection;


@WebServlet("/SendRequestController")
public class SendRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String dbName = "student_forum";
	private String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
	private String dbUser = "root";
	private String dbPass = "root";
    
    public SendRequestController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ArrayList<String> list=new ArrayList<>();
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				String guide = request.getParameter("guide");
				System.out.println("Guide Name"+guide);
				String introduction = request.getParameter("abstract");
				
				Connection conn = null;
				
				
						try {

							DriverManager.registerDriver(new com.mysql.jdbc.Driver());
							conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
							PreparedStatement ps;

						

							String sql = "insert into staff_request(guide,request) values(?,?)";

							Connection con = DBConnection.getConnection();

							ps = con.prepareStatement(sql);

							ps.setString(1, guide);
							ps.setString(2, introduction);
							

							int index = ps.executeUpdate();

							if (index > 0) {

								out.println("<script type=\"text/javascript\">");
								out.println("alert('Send Request Successfully');");
								out.println("location='StudentView.jsp';");
								out.println("</script>");
							}

						} catch (SQLException e) {

							e.printStackTrace();
						}

						finally {
							if (conn != null) {
								try {
									conn.close();
								}

								catch (SQLException ex) {
									ex.printStackTrace();
								}
							}
						}
					}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
