<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Fruit Store</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Fruit Store</h1>
	
	<table class="table table-striped table-hover">
		<thead class="thead-light">
			<tr>
				<th>Fruit</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="fruit" items="${allFruits}">
			<tr>
				<td><c:out value="${ fruit.name }"></c:out></td>
				<td><c:out value="$${ fruit.price }"></c:out></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>