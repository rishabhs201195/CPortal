<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
     
	 response.setHeader("Cache-Control" , "no-cache , no-store , must-revalidae");   
     if(session.getAttribute("username") == null){
    	 response.sendRedirect("/saclogin");
     }
  %>

<a href = "/saclogout">Logout</a>

</br>
<h1>${complaint.roll}  <br> ${complaint.name}</h1>

<form action = "view/${complaint.id}">
	Status <input type = "text" name = "status"><br>
	Message <textarea name="message" style="width:200px; height:100px;"></textarea>
  	<input type = "submit">
</form>


</body>
</html>