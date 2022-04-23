<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Time</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/styles.css">
<script type="text/javascript" src="../js/app.js"></script>	
</head>
<body>
	<h1 class="time-title"><c:out value="${ timeString }"></c:out></h1>
	
	<a href="/">Home</a>
</body>
</html>