<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<%
     
 	 response.setHeader("Cache-Control" , "no-cache , no-store , must-revalidate");   
   
      if(session.getAttribute("username") == null){
     	 response.sendRedirect("/studentlogin");
      }
%>

<div class="container" align="right">
  <a  href="/studentlogout" class="btn btn-info" role="button">Log Out</a>
</div>
<h1>Hello <%= (String)session.getAttribute("username") %> </h1>

<div class="container">
<div class="row">
<div class="col-md-6 col-md-offset-3">
        <div class="well well-sm">
 <form class="form-horizontal" action="/changepassword" method = "post">
  <fieldset>
            <legend class="text-center">Change Password</legend>
   		 <div class="form-group col-sm-12">
		    <label for="roll">Roll No.</label>
		    <input type="text" class="form-control" placeholder="Enter Roll No." name="roll">
		  </div>
		  <div class="form-group col-sm-12">
		    <label for="oldpass">Old Password</label>
		    <input type="password" class="form-control" placeholder="Enter Old Password" name="oldpass">
		  </div>
		  <div class="form-group col-sm-12">
		    <label for="newpass">New Password</label>
		    <input type="password" class="form-control" placeholder="Enter New Password" name="newpass">
		  </div>

    
            <!-- Form actions -->
            <div class="form-group">
              <div class="col-md-12 text-center">
                <button type="submit" class="btn btn-primary btn-lg">Change Password</button>
              </div>
            </div>
          </fieldset>
  	
  </form>
  </div>
  </div>
  </div>
  </div>




</body>
</html>