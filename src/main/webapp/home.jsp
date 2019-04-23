
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IIITB COMPLAINT PORTAL</title>
<link href="/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>
<div id="header">		
			<nav class="navbar navbar-fixed-top ">
			  <div class="container-fluid">
			   <!--  <div class="navbar-header">
			      <a class="navbar-brand" href="#">
			      <center><h4>WebSiteName</h4></center></a>
			    </div> -->
			    <center><h2 style="color:green">IIITB Complaint Portal</h2></center>
			    <br>
			    <ul class="nav navbar-nav  mr-auto ">
			      <li class="nav-item"><a href="/">Home</a></li>
			      <li class="nav-item"><a href="/wardenlogin">Warden</a></li>
			      <li class="nav-item"><a href="/fcomlogin">FoodCom</a></li>
			      <li class="nav-item"><a href="saclogin">SAC</a></li>
			      <li class="nav-item"><a href="/sportcomlogin">SportsCom</a></li>
			      <li class="nav-item"><a href="netcomlogin">InternetCom</a></li>
			      <li class="nav-item"><a href="/aboutus">About Us</a></li>
			    </ul>
			  </div>
			</nav>
		</div>
		<div class="sidebar">
		 <center>	<br><br><h2>Student</h2>

		  <a href="/studentlogin"><h3>Login</h3></a>
		  <a href="/register"><h3>Register</h3></a>
		  <a href="/feedback"><h3>Feedback</h3></a>
		</div>
		<div id="main">

		<div id="myCarousel" class="carousel slide" data-ride="carousel">
		    <!-- Indicators -->
		    <ol class="carousel-indicators">
		      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		      <li data-target="#myCarousel" data-slide-to="1"></li>
		      <li data-target="#myCarousel" data-slide-to="2"></li>
		    </ol>

		    <!-- Wrapper for slides -->
		    <div class="carousel-inner">

		      <div class="item active">
		        <img src="/images/img5.jpg"height="200px" width="900px" alt="Los Angeles" style="width:100% ;">
		        <!-- <div class="carousel-caption">
		          <h3>Los Angeles</h3>
		          <p>LA is always so much fun!</p>
		        </div> -->
		      </div>

		      <div class="item">
		        <img src="/images/img6.jpg" height="250" width="1000"alt="Chicago" style="width:100%;">
		        <!-- <div class="carousel-caption">
		          <h3>Chicago</h3>
		          <p>Thank you, Chicago!</p>
		        </div> -->
		      </div>
		    
		      <div class="item">
		        <img src="/images/img7.jpg" height="250" width="1000"alt="New York" style="width:100%;">
		       <!--  <div class="carousel-caption">
		          <h3>New York</h3>
		          <p>We love the Big Apple!</p>
		        </div> -->
		      </div>
		  
		    </div>

		    <!-- Left and right controls -->
		    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
		      <span class="glyphicon glyphicon-chevron-left"></span>
		      <span class="sr-only">Previous</span>
		    </a>
		    <a class="right carousel-control" href="#myCarousel" data-slide="next">
		      <span class="glyphicon glyphicon-chevron-right"></span>
		      <span class="sr-only">Next</span>
		    </a>
		  </div>
		</div>
		
			
		<div id="footer">
		 <h4>This Website is powered by IIITB.
		 © Copyright 2019, All Rights Reserved</h4>
		</div>
</body>
</html>