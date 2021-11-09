<!DOCTYPE html>
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
	               String name=(String)session.getAttribute("staff");  
	                out.print(" "+name+""); }   %></b></li>
				</ul>
					<ul class="nav navbar-nav navbar-right custom-menu">
						<li><a href="StaffView.jsp"><b>Home</b></a></li>
						<li  class="active"><a href="StaffProjectRepository.jsp"><b>Projects Repository</b></a></li>
						
						<li><a href="ViewStudentRequest.jsp"><b>View Student Requests</b></a></li>
						
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
								<br><br><br><br><br><br>
							<h2><b>Check Previous Projects</b></h2>
						<br><br>
							</div>
						</div>
						<div class="col-sm-offset-4 col-lg-6 ">
							<form class="inline" id="contactForm" action="StaffViewProjectRepository.jsp" method="post" >
								<div class="row">
								
									
									<div class="col-sm-8 height-contact-element">
										<div class="form-group">
											<select type="text" name="branch" class="form-control custom-labels" id="name" placeholder="Branch">
											<option style="background-color: black">Select Branch</option>
											<option style="background-color: black">Computer</option>
											<option style="background-color: black">Electronics&Telecommunication</option>
											<option style="background-color: black">Civil</option>
											<option style="background-color: black">Mechanical</option>
											</select>
										</div>
									</div>
									
									<div class="col-sm-8 height-contact-element">
										<div class="form-group">
											<select type="text" name="domain" class="form-control custom-labels" id="name" placeholder="Domain">
											<option style="background-color: black">Select Domain</option>
											<option style="background-color: black">Cloud Computing</option>
											<option style="background-color: black">Data Mining</option>
											<option style="background-color: black">Networking</option>
											<option style="background-color: black">Image Processing</option>
											<option style="background-color: black">Big Data</option>
											</select>
										</div>
									</div>
									
									<div class="col-sm-offset-1 col-xs-6 ">
										<div class="form-group">
											<input type="submit" class="btn btn-md btn-custom btn-noborder-radius" value="Submit"/>
											<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
										</div>
									</div>
									
									<div class="col-sm-3 col-xs-6 height-contact-element">
										<div class="form-group">
											<div id="response_holder"></div>
										</div>
									</div>
									<div class="col-sm-12 contact-msg">
									<div id="success"></div>
									</div>
								</div>
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




