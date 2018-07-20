<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
 	<meta name="viewport" content="width=device-width, initial-scale=1"/>
   	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>   
<title>List of Requests</title>
</head>
<body>
<div class="container"> 
<h1>List of Requests</h1>
<p>Here you can see the list of the Requests, edit them, remove or update.</p>
<table class="table" >
	<thead>
		<tr>
		<th width="10%">ID</th>
		<th width="20%">Employee</th>
		<th width="10%">Route</th>
		<th width="10%">Quantity</th>
		<th width="20%">Requested Date</th>
		<th width="20%">Status</th>
		</tr>
	</thead>
<tbody>
<c:forEach var="request" items="${requests}">
<tr>
	<td>${request.id}</td>
	<td>${request.employee.last_name}, ${request.employee.first_name}</td>
	<td>${request.route.desc_route}</td>
	<td>${request.quantity}</td>
	<td>${request.requestedDate}</td>
	<td>${request.status}</td>
	<td>
		<a href="${pageContext.request.contextPath}/request/edit/${request.id}.html">Edit</a><br/>
		<a href="${pageContext.request.contextPath}/request/delete/${request.id}.html">Delete</a><br/>
	</td>		
</tr>
</c:forEach>
</tbody>
</table>
<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
<p><a href="${pageContext.request.contextPath}/request/add.html">Add Request</a></p>
</div>
</body>
</html>