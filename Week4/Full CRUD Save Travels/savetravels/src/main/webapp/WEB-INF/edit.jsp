<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<div class="header">
	<h3 style="color:green">Edit an Expense:</h3>
	<a href="/expenses">Go Back</a>
</div>
<div class="exp-box">
	<form:form action="/expenses/${ expense.id }" method="post" modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
		<div class="row mb-3">
			<form:label path="name" class="col-sm-2 col-form-label">Expense Name:</form:label>
			<div class="col-sm-8">
				<form:input path="name" class="form-control"/>
			</div>
			<form:errors class="text-danger" path="name"/>
		</div>
		<div class="row mb-3">
			<form:label path="vendor" class="col-sm-2 col-form-label">Vendor:</form:label>
			<div class="col-sm-8">
				<form:input path="vendor" class="form-control"/>
			</div>
			<form:errors class="text-danger" path="vendor"/>
		</div>
		<div class="row mb-3">
			<form:label path="amount" class="col-sm-2 col-form-label">Amount:</form:label>
			<div class="col-sm-8">
				<form:input path="amount" class="form-control"/>
			</div>
			<form:errors class="text-danger" path="amount"/>
		</div>
		<div class="row mb-3">
			<form:label path="description" class="col-sm-2 col-form-label">Description:</form:label>
			<div class="col-sm-8">
				<form:input path="description" class="form-control"/>
			</div>
			<form:errors class="text-danger" path="description"/>
		</div>
		<button class="btn btn-success">Update</button>
	</form:form>
	</div>
</body>
</html>