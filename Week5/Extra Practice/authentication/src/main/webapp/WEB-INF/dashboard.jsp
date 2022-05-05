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
	<h1>Welcome, ${ user.firstName } ${ user.lastName }</h1>
	<p>This is your dashboard. Nothing to see here, yet.</p>
	
	<a href="/logout">Logout</a>
</div>
</body>
</html>