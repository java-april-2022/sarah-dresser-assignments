<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
	
	<form:form action="/products/${ product.id }/add-category" method="post">
		<div class="row mb-3">
			<form:label path="id" class="col-sm-3 col-form-label">Add Category:</form:label>
			<div class="col-sm-8">
			<form:select path="id">
				<c:forEach items="${ notCategories }" var="notCategory">
					<form:option value="${ notCategory.id }">${ notCategory.name }</form:option>
				</c:forEach>
			</form:select>
			</div>
		</div>
		<button class="btn btn-primary">Add</button>
	</form:form>
	
</div>

</body>
</html>