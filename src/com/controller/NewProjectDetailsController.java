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
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.UploadBean;
import com.connection.DBConnection;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.model.StopWords;

@WebServlet("/NewProjectDetailsController")
@MultipartConfig(maxFileSize = 1024 * 1024 * 50)
public class NewProjectDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String dbName = "student_forum";
	private String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
	private String dbUser = "root";
	private String dbPass = "root";
	String SAVE_DIR = "upload";
	String doc1;

	public NewProjectDetailsController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ArrayList<String> list=new ArrayList<>();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String groupno = request.getParameter("groupno");
		String year = request.getParameter("year");
		String guide = request.getParameter("guide");
		String branch = request.getParameter("branch");
		String domain = request.getParameter("domain");
		String title = request.getParameter("title");
		String introduction = request.getParameter("abstract");
		String guide_status = "Reject";

		UploadBean bean = new UploadBean();

		bean.setGroupno(groupno);
		bean.setYear(year);
		bean.setGuidename(guide);
		bean.setBranch(branch);
		bean.setDomain(domain);

		bean.setTitle(title);
		bean.setIntroduction(introduction);
		bean.setGuide_status(guide_status);
		InputStream inputStream = null; // input stream of the upload file

		Part part = request.getPart("file");

		String file_name = extractFileName(part);

		bean.setFilename(file_name);

		System.out.println("FirstPath===" + file_name);

		// String savePath="D:\\upload\\"+file_name;
		// String savePath = "D:" + File.separator + SAVE_DIR+ File.separator+
		// file_name;

		String savePath = "E:\\upload\\" + File.separator + "Synopsis File";

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

		bean.setFile(inputStream);

		Connection conn = null;
		String message = null;

		StudentDao dao = new StudentDaoImpl();
		ResultSet rm = dao.getfile(title);
		try {
			if (rm.next()) {
				System.out.println("File Name Exists. Please Change File Name");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Project Title Exists...');");
				out.println("</script>");
				request.getRequestDispatcher("NewProjectDetails.jsp").include(request, response);
			} else {
				try {

					DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
					PreparedStatement ps;

					boolean flag;

					String sql = "insert into projects_data(groupno,aca_year,guide,branch,domain,title,abstract,file,filename,guide_status) values(?,?,?,?,?,?,?,?,?,?)";

					Connection con = DBConnection.getConnection();

					ps = con.prepareStatement(sql);

					ps.setString(1, bean.getGroupno());
					ps.setString(2, bean.getYear());
					ps.setString(3, bean.getGuidename());
					ps.setString(4, bean.getBranch());
					ps.setString(5, bean.getDomain());
					ps.setString(6, bean.getTitle());
					ps.setString(7, bean.getIntroduction());

					if (inputStream != null) {
						ps.setBlob(8, inputStream);
					}
					ps.setString(9, bean.getFilename());
					ps.setString(10, bean.getGuide_status());

					int index = ps.executeUpdate();

					if (index > 0) {

						out.println("<script type=\"text/javascript\">");
						out.println("alert('Upload New Project Details Successfully');");
						out.println("location='StudentView.jsp';");
						out.println("</script>");
					}

				} catch (SQLException e) {

					out.println("<script type=\"text/javascript\">");
					out.println("alert('Group Number already Exists');");
					out.println("location='NewProjectDetails.jsp';");
					out.println("</script>");
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
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
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
