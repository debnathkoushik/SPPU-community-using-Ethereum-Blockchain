package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.GroupDetailsBean;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;

@WebServlet("/GroupDetailsController")
public class GroupDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GroupDetailsController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String groupno=request.getParameter("groupno");
		String year=request.getParameter("year");
		String guide=request.getParameter("guide");
		String group1=request.getParameter("group1");
		String group2=request.getParameter("group2");
		String group3=request.getParameter("group3");
		String group4=request.getParameter("group4");
		
		GroupDetailsBean bean=new GroupDetailsBean();
		
		bean.setGroupno(groupno);
		bean.setYear(year);
		bean.setGuide(guide);
		bean.setGroup1(group1);
		bean.setGroup2(group2);
		bean.setGroup3(group3);
		bean.setGroup4(group4);
		
		StudentDao dao=new StudentDaoImpl();
		
		if(dao.availableGroup(bean))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Group NO Already Exists...');");
			out.println("location='GroupDetails.jsp';");
			out.println("</script>");
		}
		
		else {
			if(dao.InsertGroupDetails(bean))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Insert Group details successfully...');");
			out.println("location='GroupDetails.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Fail...');");
			out.println("location='GroupDetails.jsp';");
			out.println("</script>");
		}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
