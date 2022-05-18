<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>

<div class="container">
	<div class="header">
		<h1>${ product.name }</h1>
		<a href="/">Home</a>
	</div>
	
	<div class="jumbotron">
		<h4 class="display-6">Categories:</h4>
		<c:forEach items="${ productCategories }" var="category">
			<p class="lead">- ${ category.name }</p>
		</c:forEach>
	</div>
	
	<form action="/products/${ product.id }/add-category" method="post">
		<div class="row">
				<label for="categoryId" class="form-control-label">Add Category:</label>
				<select name="categoryId" class="form-control md-8">
				<c:forEach items="${ notCategories }" var="notCategory">
					<option value="${ notCategory.id }">${ notCategory.name }</option>
				</c:forEach>
				</select>
		</div>
		<button class="btn btn-primary">Add</button>
	</form>
</div>

</body>
</html>