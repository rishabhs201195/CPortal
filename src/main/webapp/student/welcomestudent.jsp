<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</head>
<body>
<%
     
 	 response.setHeader("Cache-Control" , "no-cache , no-store , must-revalidate");   
   
      if(session.getAttribute("username") == null){
     	 response.sendRedirect("/studentlogin");
      }
%>

<div class="container" align="right">
  <a  href="/change" class="btn btn-info" role="button">Change Password</a>
  <a  href="/studentlogout" class="btn btn-info" role="button">Log Out</a>
  
</div>
<h1>Hello <%= (String)session.getAttribute("username") %> </h1>

<div class="container" align="center">
  <a  href="/addComplaint" class="btn btn-info" role="button">Add Complaint</a>
</div>

<h3>Your Complaints</h3>

<table class="table table-striped table-hover">
  
    <thead class="thead-dark">
    <tr>
      <th scope="col">Complaint Type</th>
      <th scope="col">Date</th>
      <th scope="col">Your Complaint</th>
      <th scope="col">Status</th>
      <th scope="col">Message</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${complaints}" var="comp">
	  <c:if test="${comp.status == 'Pending'}">
	    <tr>
	      <td>${comp.ctype}</td>
		  <td>${comp.timestamp}</td>
	      <td>${comp.compbody}</td>
	      <td>${comp.status}</td>
	       <td>${comp.message}</td>
		  </tr> 
	   </c:if>
   </c:forEach>
  <c:forEach items="${complaints}" var="comp">
	  <c:if test="${comp.status == 'Accepted'}">
	    <tr class="table-info">
	      <td>${comp.ctype}</td>
		  <td>${comp.timestamp}</td>
	      <td>${comp.compbody}</td>
	      <td>${comp.status}</td>
	       <td>${comp.message}</td>	
		  </tr> 
	   </c:if>
   </c:forEach>
   
   <c:forEach items="${complaints}" var="comp">
	  <c:if test="${comp.status == 'Rejected'}">
	    <tr class="table-danger">
	      <td>${comp.ctype}</td>
		  <td>${comp.timestamp}</td>
	      <td>${comp.compbody}</td>
	      <td>${comp.status}</td>
	       <td>${comp.message}</td>
		  </tr> 
	   </c:if>
   </c:forEach>
   
   <c:forEach items="${complaints}" var="comp">
	  <c:if test="${comp.status == 'Resolved'}">
	    <tr class="table-success">
	      <td>${comp.ctype}</td>
		  <td>${comp.timestamp}</td>
	      <td>${comp.compbody}</td>
	      <td>${comp.status}</td>
	       <td>${comp.message}</td>
		  </tr> 
	   </c:if>
   </c:forEach>
   
   
	   
	   
  </tbody>
  
</table>

</body>
</html>