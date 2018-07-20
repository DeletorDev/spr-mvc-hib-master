
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
 	<meta name="viewport" content="width=device-width, initial-scale=1"/>
   	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>   
<title>List of Employees</title>
</head>
<body>
<div class="container">
<h1>List of employees</h1>
<p>Here you can see the list of the Employees, edit them, remove or update.</p>
<table class="table" >
<thead>
<tr>
	<th width="10%">id</th>
	<th width="15%">Badge Number</th>
	<th width="15%">First Name</th>
	<th width="10%">Last Name</th>
	<th width="10%">Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="employee" items="${employees}">
<tr>
	<td>${employee.id}</td>
	<td>${employee.nu_badge}</td>
	<td>${employee.first_name}</td>
	<td>${employee.last_name}</td>
	<td>
		<a href="${pageContext.request.contextPath}/employee/edit/${employee.id}.html" class="btn btn-link">Edit</a><br/>
		<a href="${pageContext.request.contextPath}/employee/delete/${employee.id}.html" class="btn btn-link">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</div>
</body>
</html>