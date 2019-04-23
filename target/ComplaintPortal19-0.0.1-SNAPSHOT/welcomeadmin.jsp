
<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
     
	 response.setHeader("Cache-Control" , "no-cache , no-store , must-revalidae");   
   
    if(session.getAttribute("username") == null)
	 response.sendRedirect("/admin");

%>
<a href = "/adminlogout">Logout</a>

<br>
Welcome Admin

<br>
<a href = "/addStudent">Add Student Data</a>
<br>
<a href = "/updateStudent">Update Student Data</a>


</body>
</html>