<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Form</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h1>Send an Omikuji</h1>

<div class="container box">
<form action="/submit" method="post">
	<div class="form-group">
    	<label for="pickNum">Pick a number from 5 to 25:</label>
    	<input type="number" name="pickNum" min="5" max="25" class="form-control col-md-6">
	</div>
	<div class="form-group">
    	<label for="city">Enter the name of any city:</label>
    	<input type="text" class="form-control" name="city">
	</div>
</form>
</div>

</body>
</html>