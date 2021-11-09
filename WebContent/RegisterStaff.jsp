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
					<ul class="nav navbar-nav navbar-right custom-menu">
						<li class="active"><a href="Home.jsp"><b>Home</b></a></li>
						<li><a href="StudentLogin.jsp"><b>Student</b></a></li>
						<li><a href="Admin.jsp"><b>Admin</b></a></li>
						<li><a href="Staff.jsp"><b>University Staff</b></a></li>					
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
							<h2><b> University Staff Registration</b></h2>
							
							<p>If you have registered Staff Member <a href="Staff.jsp"> click Here ?</a></p>
							</div>
						</div>
						<div class="col-sm-offset-4 col-lg-6 ">
							<form class="inline" id="contactForm" action="StaffRegisterController" method="post" >
								<div class="row">
								
									<div class="col-sm-8 height-contact-element">
										<div class="form-group">
											<input type="text" name="name" required pattern="[a-zA-Z\s]+" title="Enter Your Name(eg.abc)" class="form-control custom-labels"  placeholder="Name" />
										</div>
									</div>
									
									<div class="col-sm-8 height-contact-element">
										<div class="form-group">
											<input type="text" name="contactno" class="form-control custom-labels"  required pattern="^\d{10}$" title="10 numeric characters only" placeholder="Contact No" />
										</div>
									</div>
									
									<div class="col-sm-8 height-contact-element">
										<div class="form-group">
											<input type="text" name="address" class="form-control custom-labels"  placeholder="Address" />
										</div>
									</div>
									
									<div class="col-sm-8 height-contact-element">
										<div class="form-group">
											<input type="text" name="email"  title="Enter your email (abc@gmail.com)" class="form-control custom-labels"  placeholder="Email" />
										</div>
									</div>
									
									<div class="col-sm-8 height-contact-element">
										<div class="form-group">
											<input type="password" name="password" class="form-control custom-labels" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Password must contain at least 6 characters, including UPPER/lowercase and numbers." placeholder="Password" />
										</div>
									</div>
									
									<div class="col-sm-8 height-contact-element">
										<div class="form-group">
											<select type="text" name="gender" class="form-control custom-labels" id="name" placeholder="Gender">
											<option style="background-color: black">Select Gender</option>
											<option style="background-color: black">Male</option>
											<option style="background-color: black">Female</option>
											<option style="background-color: black">Other</option>
											
											</select>
										</div>
									</div>
									
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
											<input type="text" name="designation" class="form-control custom-labels" id="name" placeholder="Designation">
											
											
										</div>
									</div>
									
									
									
									<div class="col-sm-offset-1 col-xs-6 ">
										<div class="form-group">
											<input type="submit" class="btn btn-md btn-custom btn-noborder-radius" value="Submit"/>
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




