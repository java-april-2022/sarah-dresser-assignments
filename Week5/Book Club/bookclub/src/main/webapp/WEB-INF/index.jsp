<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="container">
	<div class="header">
		<h1>Welcome!</h1>
		<h5>Join our growing community.</h5>
	</div>
	
	<div class="row">
		<div class="col reg-form">
			<h2>Register</h2>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<div class="row mb-3">
					<form:label path="name" class="col-sm-3 col-form-label">Name:</form:label>
					<div class="col-sm-8">
						<form:input path="name" class="form-control"/>
					</div>
					<form:errors path="name" class="text-danger"/>
				</div>
				<div class="row mb-3">
					<form:label path="username" class="col-sm-3 col-form-label">User Name:</form:label>
					<div class="col-sm-8">
						<form:input path="username" class="form-control"/>
					</div>
					<form:errors path="username" class="text-danger"/>
				</div>
				<div class="row mb-3">
					<form:label path="email" class="col-sm-3 col-form-label">Email:</form:label>
					<div class="col-sm-8">
						<form:input path="email" class="form-control"/>
					</div>
					<form:errors path="email" class="text-danger"/>
				</div>
				<div class="row mb-3">
					<form:label path="password" class="col-sm-3 col-form-label">Password:</form:label>
					<div class="col-sm-8">
						<form:password path="password" class="form-control"/>
					</div>
					<form:errors path="password" class="text-danger"/>
				</div>
				<div class="row mb-3">
					<form:label path="confirm" class="col-sm-3 col-form-label">Confirm pw:</form:label>
					<div class="col-sm-8">
						<form:password path="confirm" class="form-control"/>
					</div>
					<form:errors path="confirm" class="text-danger"/>
				</div>
				<button class="btn btn-primary">Submit</button>
			</form:form>
		</div>
		
		<div class="col login-form">
			<h2>Log in</h2>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<div class="row mb-3">
					<form:errors path="email" class="text-danger"/>
					<form:label path="email" class="col-sm-3 col-form-label">Email:</form:label>
					<div class="col-sm-8">
						<form:input path="email" class="form-control"/>
					</div>
				</div>
				<div class="row mb-3">
					<form:errors path="password" class="text-danger"/>
					<form:label path="password" class="col-sm-3 col-form-label">Password:</form:label>
					<div class="col-sm-8">
						<form:password path="password" class="form-control"/>
					</div>
				</div>
				<button class="btn btn-success">Login</button>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>