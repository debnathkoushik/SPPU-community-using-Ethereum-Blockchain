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

<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="assets/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom CSS -->
<link rel="stylesheet" href="assets/css/patros.css">

</head>

<body data-spy="scroll">
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul style="text-align: right">
					<li><b>Welcome Admin</b></li>
				</ul>
				<ul class="nav navbar-nav navbar-right custom-menu">
					<li><a href="AdminView.jsp"><b>Home</b></a></li>
						<li><a href="AdminProjectRepository.jsp"><b>Projects Repository</b></a></li>
						<li><a href="ViewStudentsData.jsp"><b>View Student Data</b></a></li>
						<li  class="active"><a href="ViewStaffData.jsp"><b>View Staff Data</b></a></li>
						<li><a href="Notification.jsp"><b>Send Notification</b></a></li>
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
							<br>
							<br>
							<br>
							<h2>
								<b>View Staff Data</b>
							</h2>
							<br>
							<br>
						</div>
					</div>
					<div class="col-sm-offset-2 col-lg-6 ">

						<form class="subscription-form">
							<div style="margin-left: 20px; margin-right: 20px">
								<table class="table table-bordered" style="color: black">
									<tr class="danger" style="color: black">
										<th>Name</th>
										<th>Mobile No</th>
										<th>Address</th>
										<th>Email</th>

										<th>Gender</th>
										<th>Branch</th>
										<th>Designation</th>
										<th>Action</th>
									</tr>

									<%
										Connection con = DBConnection.getConnection();
										Statement st = con.createStatement();
										ResultSet rs = st.executeQuery("select * from staffreg");

										while (rs.next()) {
									%>
									<TR style="color: white">
									
										<td><%=rs.getString(2)%></td>
										<td><%=rs.getString(3)%></td>
										<td><%=rs.getString(4)%></td>
										<td><%=rs.getString(5)%></td>
										<td><%=rs.getString(7)%></td>
										<td><%=rs.getString(8)%></td>
										<td><%=rs.getString(9)%></td>
										
										<td><a style="color:red"
											href="StaffDeleteController?id=<%=rs.getString(1)%>">Delete</a></td>
									</TR>

									<%
										}
									%>

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
	<script
		src="//maps.googleapis.com/maps/api/js?v=3.exp&amp;sensor=true&amp;libraries=places"></script>

	<!-- Portfolio -->
	<script src="assets/js/jquery.quicksand.js"></script>






</body>
</html>




