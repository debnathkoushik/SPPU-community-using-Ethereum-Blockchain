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
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.mail.SendNotification;

@WebServlet("/StaffNotificationController")
public class StaffNotificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StaffNotificationController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String notification = request.getParameter("staff");
		StudentDao dao=new StudentDaoImpl();	
		dao.addNotification1(notification);

		String sql = "select * from staffreg";

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String email = rs.getString(5);

				SendNotification sen = new SendNotification();
				sen.Notification(email, notification);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Notification Send Successfully')");
		out.println("location='Notification.jsp';");
		out.println("</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
