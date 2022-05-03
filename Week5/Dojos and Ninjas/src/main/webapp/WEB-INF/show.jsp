<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container">
	<div class="header">
		<h1>${ dojo.name } Location Ninjas</h1>
		<a href="/dojos">Home</a>
	</div>
	<table class="table table-light table-striped">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ ninjas }" var="ninja">
			<tr>
				<td>${ ninja.firstName }</td>
				<td>${ ninja.lastName }</td>
				<td>${ ninja.age }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>