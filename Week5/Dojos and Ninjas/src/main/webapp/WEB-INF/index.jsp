<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container">
	<h1>Welcome to our Dojos!</h1>
	
	<table class="table table-dark table-striped">
		<thead class="thead-light">
			<tr>
				<td>Dojo Locations</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ allDojos }" var="dojo">
				<tr>
					<td><a href="/dojo/${ dojo.id }">${ dojo.name }</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<span class="links">
		<a href="/dojos/new">Register New Dojo</a>
		<a href="/ninjas/new">Register New Ninja</a>
	</span>
</div>
</body>
</html>