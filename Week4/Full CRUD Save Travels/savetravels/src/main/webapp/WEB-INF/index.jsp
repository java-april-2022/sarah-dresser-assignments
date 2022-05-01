<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<div class="index-header">
	<h1>Save Travels</h1>
	<h6>Your digital pocketbook</h6>
</div>

<div class="container">
	<!-- table for reading items list -->
	<table class="table table-striped table-bordered">
		<thead>
    		<tr>
      			<th scope="col">Expense</th>
      			<th scope="col">Vendor</th>
      			<th scope="col">Amount</th>
      			<th scope="col">Actions</th>
    		</tr>
  		</thead>
	  	<tbody>
		    <c:forEach items="${ expenses }" var="item">
		    <tr>
		    	<td><a href="/expenses/show/${ item.id }">${ item.name }</a></td>
		    	<td>${ item.vendor }</td>
		    	<td><fmt:formatNumber value="${ item.amount }" type="currency"/></td>
		    	<td>
		    		<span class="links">
		    		<a href="/expenses/edit/${ item.id }">edit</a>
		    		<form action="/expenses/${item.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="delete" class="btn btn-danger">
					</form>
		    		</span>
		    	</td>
		    </tr>
		    </c:forEach>
		</tbody>
		<tfoot>
			<tr class="table-info">
				<td colspan="2">Total:</td>
				<td colspan="2"><fmt:formatNumber value="${ totalAmount }" type="currency"/></td>
			</tr>
		</tfoot>
	</table>
	<!-- form for adding expenses to list -->
	<div class="exp-box">
	<h3>Add an Expense:</h3>
	<form:form action="/expenses" method="post" modelAttribute="newExpense">
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
		<button class="btn btn-primary">Add</button>
	</form:form>
	</div>
</div>	

</body>
</html>