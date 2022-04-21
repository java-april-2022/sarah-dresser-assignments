<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Receipt</title>
</head>
<body>
	<h1>Hello World!</h1>
	<h3>Customer Name: <c:out ${ name }/></h3>
	<h5>Item Name: <c:out ${ itemName }/></h5>
	<h5>Price: $<c:out ${ price }/></h5>
	<h5>Description: <c:out ${ description }/></h5>
	<h5>Vendor: <c:out ${ vendor }/></h5>
</body>
</html>