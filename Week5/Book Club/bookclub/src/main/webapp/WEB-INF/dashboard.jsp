<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
</head>
<body>
<div class="container">
	<div class="header">
		<div class="header-row">
			<h1>Welcome, ${ user.name }</h1>
			<a href="/logout">Logout</a>
		</div>
		<div class="header-row">
			<p>Books from everyone's shelves:</p>
			<a href="/books/new">+ Add a book to my shelf!</a>
		</div>
	</div>
	
	<table class="table table-light">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ allBooks }" var="book">
			<tr>
				<td>${ book.id }</td>
				<td><a href="/books/${ book.id }">${ book.name }</a></td>
				<td>${ book.author }</td>
				<td>${ book.user.name }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>