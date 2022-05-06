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
	
	<table>
	</table>
</div>
</body>
</html>