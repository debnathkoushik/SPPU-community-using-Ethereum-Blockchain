package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.connection.DBConnection;

/**
 * Servlet implementation class SendController
 */
@WebServlet("/SendController")
@MultipartConfig(maxFileSize = 1024 * 1024 * 50)
public class SendController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String dbName = "student_forum";
	private String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
	private String dbUser = "root";
	private String dbPass = "root";
	String SAVE_DIR = "upload";
  
    public SendController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		InputStream inputStream = null; // input stream of the upload file

		Part part = request.getPart("file");

		String file_name = extractFileName(part);

		

		System.out.println("FirstPath===" + file_name);

		// String savePath="D:\\upload\\"+file_name;
		// String savePath = "D:" + File.separator + SAVE_DIR+ File.separator+
		// file_name;

		String savePath = "E:\\upload\\" + File.separator + "Notes";

		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		String filePath = savePath + File.separator + file_name;

		part.write(filePath);

		if (part != null) {
			System.out.println(part.getName());
			System.out.println(part.getSize());
			System.out.println(part.getContentType());

			inputStream = part.getInputStream();
		}
		
		Connection conn = null;
		
		
		try {

			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
			PreparedStatement ps;

		

			String sql = "insert into files(filename) values(?)";

			Connection con = DBConnection.getConnection();

			ps = con.prepareStatement(sql);

			ps.setString(1, file_name);
		

			int index = ps.executeUpdate();

			if (index > 0) {

				out.println("<script type=\"text/javascript\">");
				out.println("alert('Send Notes Successfully');");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}
