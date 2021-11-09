<!DOCTYPE html>
<%@ page import="javax.servlet.http.HttpSession" %>
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
				<li><b>Welcome Admin</b></li>
				</ul>
					<ul class="nav navbar-nav navbar-right custom-menu">
						<li class="active"><a href="AdminView.jsp"><b>Home</b></a></li>
						<li><a href="AdminProjectRepository.jsp"><b>Projects Repository</b></a></li>
						
						<li><a href="ViewStudentsData.jsp"><b>View Student Data</b></a></li>
						<li><a href="ViewStaffData.jsp"><b>View Staff Data</b></a></li>
						<li><a href="Notification.jsp"><b>Send Notification</b></a></li>
						<li><a href="LogoutController"><b>Logout</b></a></li>
					</ul>
				</div>
			</div>
		</nav>



		<section id="contact">
		<br><br><br><br>
			<div class="container"> 
				<div class="row">
					<div class="col-md-12">
						<div class="col-lg-12">
							
										<img src="assets/images/admin.jpg" height="650" width="1130">  
									<div class="col-sm-3 col-xs-6 height-contact-element">
										<div class="form-group">
											<div id="response_holder"></div>
										</div>
									</div>
									<div class="col-sm-12 contact-msg">
									<div id="success"></div>
									</div>
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




