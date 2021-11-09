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
import com.mail.SendNotification;

@WebServlet("/StaffStudentNotificationController")
public class StaffStudentNotificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PreparedStatement ps;
	SendNotification ss = new SendNotification();

	public StaffStudentNotificationController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String groupno = request.getParameter("groupno");
		String student = request.getParameter("student");
		String g1 = null, g2 = null, g3 = null, g4 = null;
		Connection con = DBConnection.getConnection();
		String sql = "select * from group_details where groupno='"+groupno+"'";

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				g1 = rs.getString(5);
				g2 = rs.getString(6);
				g3 = rs.getString(7);
				g4 = rs.getString(8);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		String sql1 = "select email from studentreg where name='" + g1 + "'";

		try {
			ps = con.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String email = rs.getString(1);
				ss.Notification(email, student);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		String sql2 = "select email from studentreg where name='" + g2 + "'";

		try {
			ps = con.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String email = rs.getString(1);
				ss.Notification(email, student);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		String sql3 = "select email from studentreg where name='" + g3 + "'";

		try {
			ps = con.prepareStatement(sql3);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String email = rs.getString(1);
				ss.Notification(email, student);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		String sql4 = "select email from studentreg where name='" + g4 + "'";

		try {
			ps = con.prepareStatement(sql4);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String email = rs.getString(1);
				ss.Notification(email, student);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		out.println("<script type=\"text/javascript\">");
		out.println("alert('Notification Send Successfully')");
		out.println("location='StudStaffNotification.jsp';");
		out.println("</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
