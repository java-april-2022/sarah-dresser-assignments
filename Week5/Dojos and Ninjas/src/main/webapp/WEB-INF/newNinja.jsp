<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container">
	<div class="header">
		<h1>Register a New Ninja</h1>
		<a href="/dojos">Home</a>
	</div>

	<div class="form-box">
		<form:form action="/create-ninja" method="post" modelAttribute="newNinja">
			<div class="row mb-3">
				<form:label path="dojo" class="col-sm-2 col-form-label">Dojo Name:</form:label>
				<div class="col-sm-8">
					<form:select path="dojo" class="form-control">
						<form:option value="">Select Dojo</form:option>
						<c:forEach items="${ allDojos }" var="dojo">
						<form:option value="${ dojo.id }">${dojo.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<form:errors path="dojo" class="text-danger"/>
			</div>
			<div class="row mb-3">
				<form:label path="firstName" class="col-sm-2 col-form-label">First Name:</form:label>
				<div class="col-sm-8">
					<form:input path="firstName" class="form-control"/>
				</div>
				<form:errors path="firstName" class="text-danger"/>
			</div>
			<div class="row mb-3">
				<form:label path="lastName" class="col-sm-2 col-form-label">Last Name:</form:label>
				<div class="col-sm-8">
					<form:input path="lastName" class="form-control"/>
				</div>
				<form:errors path="lastName" class="text-danger"/>
			</div>
			<div class="row mb-3">
				<form:label path="age" class="col-sm-2 col-form-label">Age:</form:label>
				<div class="col-sm-8">
					<form:input path="age" class="form-control"/>
				</div>
				<form:errors path="age" class="text-danger"/>
			</div>
			<button class="btn btn-primary">Register</button>
		</form:form>
	</div>
</div>
</body>
</html>