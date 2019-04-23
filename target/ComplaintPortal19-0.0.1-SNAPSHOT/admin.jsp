<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1" />
<title>Insert title here</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="/js/postrequest.js"></script>
<!-- <script src="/getrequest.js"></script> -->
</head>
<body>
<%
     
	 response.setHeader("Cache-Control" , "no-cache , no-store , must-revalidae");   
   
    if(session.getAttribute("username") == null)
	 response.sendRedirect("/admin");

%>
<a href = "/adminlogout">Logout</a>
	<div class="container">
		<h2>Student Entry Form</h2>
		<form id="addForm">
			<div class="form-group">
				<label for="roll">Roll no.:</label> <input type="text"
					class="form-control" id="roll" placeholder="Enter Roll No."
					name="roll" required>
			</div>
			<div class="form-group">
				<label for="room">Room No.:</label> <input type="text"
					class="form-control" id="room" placeholder="Enter Room No."
					name="room" required>
			</div>
			<div class="form-group">
				<label for="hostel">Hostel :</label>
				 <select class="form-control" id="hostel" name="hostel">
				    <option name="Bhaskara">Bhaskara</option>
				    <option name="Lilavati">Lilavati</option>
				  </select> 
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<br>
		<div class="col-md-8" id="postResultDiv"></div>
		
	</div>
</body>
</html>
