<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
   	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>   
<title>Add employee page</title>
</head>
<body>
<div class="container">
<h1>Add employee page</h1>
<p>Here you can add a new employee.</p>
<form:form class="form-horizontal" method="POST" commandName="employee" action="${pageContext.request.contextPath}/employee/add.html">
<table class="table">
<tbody>
	<tr>	
		<td><label class="control-label col-sm-2" for="nu_badge">Badge Number:</label>
			<form:input path="nu_badge" /></td>
	</tr>
	<tr>
		<td><label class="control-label col-sm-2" for="first_name">First Name:</label>
			<form:input path="first_name" /></td>
	</tr>
	<tr>
		<td><label class="control-label col-sm-2" for="last_name">Last name:</label>
			<form:input path="last_name" /></td>
	</tr>
	<tr>
		<td><button type="submit" class="btn btn-primary">Add</button></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</div>
</body>
</html>