<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container">
	<h1>New Category</h1>
	<a href="/">Home</a>
	
	<form:form action="/categories/save" modelAttribute="newCategory" method="post">
		<div class="row mb-3">
			<form:errors path="name" class="text-danger"/>
			<form:label path="name" class="col-sm-3 col-form-label">Name:</form:label>
			<div class="col-sm-8">
				<form:input path="name" class="form-control"/>
			</div>
		</div>
		<button class="btn btn-primary">Add</button>
	</form:form>

</div>
</body>
</html>