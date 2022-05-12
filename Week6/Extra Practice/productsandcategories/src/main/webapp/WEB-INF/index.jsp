<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container">
	<div class="header">
	<h1>Home Page</h1>
	
	<div class="links">
		<a href="/products/new">New Product</a><br/>
		<a href="/categories/new">New Category</a>
	</div>
	</div>
	
	<table class="table table-light table-bordered">
		<thead>
			<tr>
				<th>Products</th>
				<th>Categories</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<ul class="list-group">
						<c:forEach items="${ allProducts }" var="product">
						<li class="list-group-item"><a href="/products/${ product.id }">${ product.name }</a></li>
						</c:forEach>
					</ul>
				</td>
				<td>
					<ul class="list-group">
						<c:forEach items="${ allCategories }" var="category">
						<li class="list-group-item"><a href="">${ category.name }</a></li>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</tbody>
	</table>
</div>
</body>
</html>