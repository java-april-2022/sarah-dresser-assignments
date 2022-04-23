<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Receipt</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
<div class="container">
	<div class="col-lg" style="background-color:cornsilk blue; margin:20px;">
	<h1>Customer Name: <c:out value="${name}"></c:out></h1>
	<h3>Item Name: <c:out value="${itemName}"></c:out></h3>
	<h3>Price: <c:out value="$${price}"></c:out></h3>
	<h3>Description: <c:out value="${description}"></c:out></h3>
	<h3>Vendor: <c:out value="${vendor}"></c:out></h3>
	</div>
</div>
</body>
</html>