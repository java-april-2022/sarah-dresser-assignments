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
	<h1>Fruity Loops Store</h1>
	
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
				<td>${ fruit.name }</td>
				<td><c:out value="$${ fruit.price }"></c:out></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h3>Number of Fruits: ${ numFruits }</h3>
	
</body>
</html>