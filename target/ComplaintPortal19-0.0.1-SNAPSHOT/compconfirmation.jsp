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

<div id = "container">
Hi ${complaint.roll} Your Complaint is successfully added.
Your Id reference no. is ${complaint.id}.
Keep this Id to track the status of the complaint
</div>

</body>
</html>