<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
 	<meta name="viewport" content="width=device-width, initial-scale=1"/>
   	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>   
<title>List of Routes</title>
</head>
<body>
<div class="container">
<h1>List of Routes</h1>
<p>Here you can see the list of the Routes, edit them, remove or update.</p>
<table class="table" >
<thead>
<tr>
	<th width="10%">id</th>
	<th width="15%">Description</th>
	<th width="15%">Price</th>
	<th width="10%">Status</th>
</tr>
</thead>
<tbody>
<c:forEach var="routes" items="${routes}">
<tr>
	<td>${routes.id}</td>
	<td>${routes.desc_route}</td>
	<td>${routes.price}</td>
	<td>
		<a href="${pageContext.request.contextPath}/routes/edit/${routes.id}.html" class="btn btn-link">Edit</a><br/>
		<a href="${pageContext.request.contextPath}/routes/delete/${routes.id}.html" class="btn btn-link">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</div>
</body>
</html>