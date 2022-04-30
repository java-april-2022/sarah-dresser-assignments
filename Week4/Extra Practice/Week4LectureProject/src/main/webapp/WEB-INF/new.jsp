<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Art</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h1>Add a New Work of Art!</h1>

	<form:form action="/create" method="post" modelAttribute="newArt">
		<p>
			<form:label path="title">Title</form:label>
			<form:input path="title"/>
			<form:errors class="text-danger" path="title"/>
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:input path="description"/>
			<form:errors class="text-danger" path="description"/>
		</p>
		<p>
			<form:label path="url">url</form:label>
			<form:input path="url"/>
			<form:errors class="text-danger" path="url"/>
		</p>
		<button>Create Art</button>
	</form:form>

</body>
</html>