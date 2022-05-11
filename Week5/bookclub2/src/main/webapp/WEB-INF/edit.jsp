<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="header-row">
			<h3>Add a book to your shelf!</h3>
			<a href="/books">Back to the Shelves</a>
		</div>
	</div>
	
	<form:form action="/books/${ book.id }/update" modelAttribute="book" method="post">
		<div class="row mb-3">
			<form:errors path="title" class="text-danger"/>
			<form:label path="title" class="col-sm-3 col-form-label">Title:</form:label>
			<div class="col-sm-8">
						<form:input path="title" class="form-control"/>
			</div>
		</div>
		<div class="row mb-3">
			<form:errors path="author" class="text-danger"/>
			<form:label path="author" class="col-sm-3 col-form-label">Author:</form:label>
			<div class="col-sm-8">
				<form:input path="author" class="form-control"/>
			</div>
		</div>
		<div class="row mb-3">
			<form:errors path="thoughts" class="text-danger"/>
			<form:label path="thoughts" class="col-sm-3 col-form-label">Thoughts:</form:label>
			<div class="col-sm-8">
				<form:textarea path="thoughts" rows = "3" cols="6" class="form-control"/>
			</div>
		</div>
		<form:hidden path="user" value="${ user.id }"/>
		<button class="btn btn-primary">Save</button>
	</form:form>

</div>
</body>
</html>