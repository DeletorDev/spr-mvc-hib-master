<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Request page</title>
</head>
<body>
<h1>Edit Request page</h1>
<p>Here you can edit the existing Request.</p>
<p>${message}</p>
<form:form method="POST" commandName="request" action="${pageContext.request.contextPath}/request/edit/${request.id}.html">
<table>
<tbody>
 	<tr>
 		<td>Employee:</td>
		<td><form:input class="form-control" type="text" path="employee" for="id" value="${request.employee.last_name}, ${request.employee.first_name}" disabled="true"/></td>
	</tr>
	<tr>
		<td>Route:</td>
		<td><form:input class="form-control" type="text" path="route" for="id" value="${request.route.desc_route}" disabled="true"/></td>
	</tr>
	<tr>
		<td>Quantity:</td>
		<td><form:input type="text" class="form-control" path="quantity" /></td>
	</tr>
	<tr>
		<td>Requested Date:</td>
		<td><form:input type="text" class="form-control" path="requestedDate" value="${request.requestedDate}" disabled="true" /></td>
	</tr>
	<tr>
		<td>Status</td>
		<td>
			<form>
			    <div class="radio">
			      <label><input type="radio" name="optradio" checked="checked"/>Requested</label>
			    </div>
			    <div class="radio">
			      <label><input type="radio" name="optradio"/>Delivered</label>
			    </div>
			 </form>
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="Edit" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>