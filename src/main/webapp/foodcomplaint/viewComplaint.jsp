<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/feedback.css" rel="stylesheet" type="text/css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<%
     
	 response.setHeader("Cache-Control" , "no-cache , no-store , must-revalidae");   
   
     if(session.getAttribute("username") == null){
    	 response.sendRedirect("/fcomlogin");
     }
  %>


<br>

<div class="container">
 
<h1>${complaint.roll}  <br> ${complaint.name}</h1>
 
 
<div class="form-group purple-border">
  <label for="exampleFormControlTextarea4">Complaint Message : </label>
  <textarea readonly class="form-control" id="exampleFormControlTextarea4" rows="3">${complaint.compbody}</textarea>
</div>

</div>

<br>
<div class="container">
	<div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="well well-sm">
          <form class="form-horizontal" action="view/${complaint.id}" >
          <fieldset>
            <legend class="text-center">Response</legend>
   		<div class="form-group col-sm-12">
		    <label for="exampleFormControlSelect1">Status</label>
		    <select class="form-control " id="exampleFormControlSelect1" name = "status">
		      <option value = "Accepted">Accepted</option>
		      <option value = "Resolved">Resolved</option>
		      <option value = "Rejected">Rejected</option>
		    </select>
		  </div>
		  <div class="form-group col-sm-12">
		    <label for="exampleFormControlTextarea1">Message</label>
		    <textarea class="form-control " id="exampleFormControlTextarea1" rows="3" name = "message"></textarea>
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