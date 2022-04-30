<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>View NFTs</title>

<!-- CSS only -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<h1>Discover extraordinary NFTs!</h1>

<div class="container">
	<p>
		<a href="/">Dashboard</a>
		<a href="/new">New Art</a>
	</p>
	<table class="table table-dark">
		<thead>
			<tr>
				<th>Art Name</th>
				<th>Description</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ allArts }" var="art">
			<tr>
				<td>${ art.title }</td>
				<td>${ art.description }</td>
				<td><a href="/edit/${art.id}">Edit</a> | <a href="/delete/${art.id }">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>
