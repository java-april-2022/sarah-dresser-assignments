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

<header>
	<h1>Save Travels</h1>
	<h6>Your digital pocketbook</h6>
</header>

<div class="container">
	<!-- table for reading items list -->
	<table class="table table-striped">
		<thead class="thead-dark">
    		<tr>
      			<th scope="col">Expense</th>
      			<th scope="col">Vendor</th>
      			<th scope="col">Amount</th>
    		</tr>
  		</thead>
	  	<tbody>
		    <c:forEach items="${ expenses }" var="item">
		    <tr>
		    	<td>${ item.name }</td>
		    	<td>${ item.vendor }</td>
		    	<td><fmt:formatNumber value="${ item.amount }" type="currency"/></td>
		    </tr>
		    </c:forEach>
		</tbody>
	</table>
	<!-- form for adding expenses to list -->
	<div class="exp-box">
	<h3>Add an Expense:</h3>
	<form:form action="/create" method="post" modelAttribute="newExpense">
		<p>
			<form:label path="name">Expense Name:</form:label>
			<form:input path="name"/>
			<form:errors class="text-danger" path="name"/>
		</p>
		<p>
			<form:label path="vendor">Vendor:</form:label>
			<form:input path="vendor"/>
			<form:errors class="text-danger" path="vendor"/>
		</p>
		<p>
			<form:label path="amount">Amount:</form:label>
			<form:input path="amount"/>
			<form:errors class="text-danger" path="amount"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:input path="description"/>
			<form:errors class="text-danger" path="description"/>
		</p>
		<button class="btn btn-primary">Add</button>
	</form:form>
	</div>
</div>	

</body>
</html>