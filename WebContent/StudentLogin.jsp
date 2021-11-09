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
						<li ><a href="Home.jsp"><b>Home</b></a></li>
						<li class="active"><a href="StudentLogin.jsp"><b>Student</b></a></li>
						<li><a href="Admin.jsp"><b>Admin</b></a></li>
						<li><a href="Staff.jsp"><b>University Staff</b></a></li>	
					</ul>
				</div>
			</div>
		</nav>
<br><br><br><br>
		<section id="contact">
			<div class="container"> 
				<div class="row">
					<div class="col-md-12">
						<div class="col-lg-12">
							<div class="text-center color-elements">
							<h2><b>Student Login</b></h2>
							<br>
							<p>If you have new user <a href="Register.jsp" style="color:red"> click Here ?</a></p>
							</div>
						</div>
						<div class="col-sm-offset-4 col-lg-6 ">
							<form  id="contactForm" action="StudentLoginController" method="post" >
								<div class="row">
									<div class="col-sm-8 height-contact-element">
										<div class="form-group">
											<input type="text" name="email" class="form-control custom-labels" id="name" placeholder="Email" required data-validation-required-message="Please enter your email!"/>
											<p class="help-block text-danger"></p>
										</div>
									</div>
									<br>
									<div class="col-sm-8 height-contact-element">
										<div class="form-group">
											<input type="password" name="password" class="form-control custom-labels" id="name" placeholder="password" required data-validation-required-message="Please enter your password!"/>
											<p class="help-block text-danger"></p>
										</div>
										<br>
									</div>
									
									
									<div class="col-sm-offset-1 col-xs-6 ">
										
										
										
											<input type="submit" class="btn btn-md btn-custom btn-noborder-radius" value="Login"/>
											 
											
											<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
									
									</div>
									<br><br><br><br><br><br><br>
									<a href="StudentForgotPassword.jsp" style="color:red">Forgot Password ?</a>
								
									
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




