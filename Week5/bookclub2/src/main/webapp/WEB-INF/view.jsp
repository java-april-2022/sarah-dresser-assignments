<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Review</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>

<div class="container">
	<div class="header">
		<div class="header-row">
			<h3>${ book.title }</h3>
			<a href="/books">Back to the Shelves</a>
		</div>
	</div>
	
	<div class="jumbotron">
	<c:choose>
		<c:when test = "${ user.id == book.user.id }">
			<h4 class="display-6"><b>You read ${ book.title } by ${ book.author }</b></h4>
		<p class="lead">Here are your thoughts:</p>
		</c:when>
		<c:otherwise>
			<h4 class="display-6"><b>${ book.user.name } read ${ book.title } by ${ book.author }</b></h4>
			<p class="lead">Here are ${ book.user.name }'s thoughts:</p>
		</c:otherwise>
	</c:choose>
		<hr class="my-4">
		<p class="lead"><em>${ book.thoughts }</em></p>
		<hr class="my-4">
		<c:choose>
			<c:when test="${ user.id == book.user.id }">
			<a href="/books/${ book.id }/edit" class="btn btn-primary btn-md">Edit</a>
			</c:when>
		</c:choose>
	</div>
	
</div>

</body>
</html>