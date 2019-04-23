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
 <form class="form-horizontal" action="/success" method = "post">
  <fieldset>
            <legend class="text-center">Add Complaint</legend>
   		<div class="form-group col-sm-12">
		    <label for="ctype">Complaint Type:</label>
		    <select class="form-control " id="ctype" name = "ctype">
		        <option value="sac">Electricity</option>
				<option value="mess">Food</option>
				<option value="mess">Canteen</option>
				<option value="sac">Cleaning</option>
				<option value="sport">Sports</option>
				<option value="hostel">Others</option>
		    </select>
		  </div>
		  <div class="form-group col-sm-12">
		    <label for="compbody">Complaint</label>
		    <textarea class="form-control " id="compbody" rows="4" name = "compbody"></textarea>
		  </div>

    
            <!-- Form actions -->
            <div class="form-group">
              <div class="col-md-12 text-center">
                <button type="submit" class="btn btn-primary btn-lg">Submit</button>
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