<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.connection.DBConnection"%>
<%@page import="java.sql.Connection"%>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>SPPU community using Ethereum Blockchain Technology</title>
		<!-- Bootstrap Core CSS -->
		<link href="assets/css/bootstrap.min.css" rel="stylesheet">
		<!-- Custom Fonts -->
		<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
		<!-- Custom CSS -->
		<link rel="stylesheet" href="assets/css/patros.css" >
		
	</head>

	<body data-spy="scroll">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul style="text-align:right">
				<li><b>Welcome<%response.setContentType("text/html");  
				 HttpSession sessio=request.getSession(true);  
	               if(session!=null){  
	               String name=(String)session.getAttribute("student");  
	                out.print(" "+name+""); }   %></b></li>
				</ul>
					<ul class="nav navbar-nav navbar-right custom-menu">
						<li><a href="GroupDetails.jsp"><b>Group Details</b></a></li>
						<li><a href="ProjectRepository.jsp"><b>Projects Repository</b></a></li>
						<li><a href="VerifyTitle.jsp"><b>Verify Title</b></a></li>
						<li><a href="NewProjectDetails.jsp"><b>New Project Details</b></a></li>	
						<li><a href="CheckProjectStatus.jsp"><b>Check Status</b></a></li>
						<li><a href="DownloadFiles.jsp"><b>Download Files</b></a></li>
						<li><a href="LogoutController"><b>Logout</b></a></li>
					</ul>
				</div>
			</div>
		</nav>


		<section id="contact">
			<div class="container"> 
				<div class="row">
					<div class="col-md-12">
						<div class="col-lg-12">
							<div class="text-center color-elements">
								<br><br><br>
							<h2><b>Download Files</b></h2>
						<br><br>
							</div>
						</div>
						<div class=" col-lg-12 ">
						
						<form class="subscription-form">
                    <div style="margin-left:20px;margin-right:20px">
                    <table class="table table-bordered" style="color:black">
                    <tr class="danger" style="color:black">
                    <th> Group Name   </th>
                     <th> Year</th>
                      <th>Guide</th>
                     <th>Branch</th>
                     <th>Domain</th>
                     <th>Title</th>
                    
                     <th>Action</th>
                     </tr>
							
							<%
							Connection con=DBConnection.getConnection();
							Statement st=con.createStatement();
							 ResultSet rs=st.executeQuery("select * from projects_data");
				
				          while(rs.next())
		                     {
		                    	 %>
		                    	 <TR style="color:white">
		                    	 <td><%=rs.getString(1) %></td>
		                    	 <td><%=rs.getString(2) %></td>
		                    	 <td><%=rs.getString(3) %></td>
		                    	 <td><%=rs.getString(4) %></td>
		                    	 <td><%=rs.getString(5) %></td>
		                    	
		                    	 <td><%=rs.getString(6) %></td>
		                    	 <td><a href="DownloadFileController?filename=<%=rs.getString(9)%>"><b>Download</b></a></td>
		                    
		                    	 </TR>
		                    	 
		                    <%} %> 
		                   
		                    </table>
		                    
		                            
		                  </form>
							
							
							
							
							
						</div>
						
						<br>
						
						<div class=" col-lg-12 ">
						
						<form class="subscription-form">
                    <div style="margin-left:20px;margin-right:20px">
                    <table class="table table-bordered" style="color:black">
                    <tr class="danger" style="color:black">
                    
                    <th> File Name   </th>
                     <th> Action</th>
                     
                     </tr>
							
							<%
							Connection con1=DBConnection.getConnection();
							Statement st1=con.createStatement();
							 ResultSet rs1=st1.executeQuery("select * from files");
				
				          while(rs.next())
		                     {
		                    	 %>
		                    	 <TR style="color:white">
		                    	 <td><%=rs1.getString(1) %></td>
		                    	 <td><%=rs1.getString(2) %></td>
		                    	
		                    	
		            
		                    	 <td><a href="DownloadFileController1?filename=<%=rs1.getString(2)%>"><b>Download</b></a></td>
		                    
		                    	 </TR>
		                    	 
		                    <%} %> 
		                   
		                    </table>
		                    
		                            
		                  </form>
							
							
							
							
							
						</div>
					</div>
				</div>
			</div>
		</section>

		

		<!-- jQuery -->
		<script src="assets/js/jquery.js"></script>
		<!-- Bootstrap Core JavaScript -->
		<script src="assets/js/bootstrap.min.js"></script>

		<!-- Google Map -->
		<script src="//maps.googleapis.com/maps/api/js?v=3.exp&amp;sensor=true&amp;libraries=places"></script>

		<!-- Portfolio -->
		<script src="assets/js/jquery.quicksand.js"></script>	    
	

		



</body>
</html>



