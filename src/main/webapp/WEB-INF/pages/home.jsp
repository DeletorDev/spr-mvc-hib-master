<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
   <meta name="viewport" content="width=device-width, initial-scale=1"/>
   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Home page</title>
</head>
	<body>
		<div class="container">
		<h1>Home Page</h1>
		<p>
		${message}<br />
			<a href="${pageContext.request.contextPath}/employee/add.html" class="btn btn-link">Add New Employee</a><br/>
			<a href="${pageContext.request.contextPath}/employee/list.html" class="btn btn-link">Employee list</a><br/>
			<a href="${pageContext.request.contextPath}/request/add.html" class="btn btn-link">Add New Request</a><br/>
			<a href="${pageContext.request.contextPath}/request/list.html" class="btn btn-link">Request list</a><br/>
			<a href="${pageContext.request.contextPath}/routes/add.html" class="btn btn-link">Add New Route</a><br/>
			<a href="${pageContext.request.contextPath}/routes/list.html" class="btn btn-link">Route list</a><br/>			
		</p>		
		</div>
	</body>
</html>