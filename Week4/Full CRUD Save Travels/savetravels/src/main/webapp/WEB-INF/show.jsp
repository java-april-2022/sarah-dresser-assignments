<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="header">
		<h3 style="color: #007bff">Expense Details</h3>
		<a href="/expenses">Go Back</a>
	</div>
	<div class="show-box">
		<div class="row">
			<div class="col col-lg-4">
				Expense Name:
			</div>
			<div class="col col-lg-8">
				${ expense.name }
			</div>
		</div>
		<div class="row">
			<div class="col col-lg-4">
				Expense Description:
			</div>
			<div class="col col-lg-8">
				${ expense.description }
			</div>
		</div>
		<div class="row">
			<div class="col col-lg-4">
				Vendor:
			</div>
			<div class="col col-lg-8">
				${ expense.vendor }
			</div>
		</div>
		<div class="row">
			<div class="col col-lg-4">
				Amount Spent:
			</div>
			<div class="col col-lg-8">
				<fmt:formatNumber value="${ expense.amount }" type="currency"/>
			</div>
		</div>
	</div>
</body>
</html>