<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/login.css" rel="stylesheet" type="text/css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>

<div class="sidenav">
         <div class="login-main-text">
            <h2>Student Login<br> </h2>
            <br>
            <p>Check-in to track Complaints!</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form action = "/login-student" method="post">
                  <div class="form-group">
                     <label>Roll Number</label>
                     <input type="text" class="form-control" placeholder="Roll Number" name="roll">
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" placeholder="Password" name="password">
                  </div>
                  <button type="submit" class="btn btn-black">Submit</button>
                  <h6 align="left"><a href = "/forgot">Forgot Password</a></h6>
               </form>
               
            </div>
         </div>
      </div>





</body>
</html>