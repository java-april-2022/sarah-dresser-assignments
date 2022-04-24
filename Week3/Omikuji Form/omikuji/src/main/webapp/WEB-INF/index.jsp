<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Form</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h1>Send an Omikuji</h1>

<div class="container box">

<form action="submit" method="post">
  <div class="row">
    <div class="col-md-4">
      <label for="pickNum">Pick a number from 5 to 25:</label>
      <input type="number" name="pickNum" min="5" max="25" class="form-control">
    </div>
  </div>
  <div class="row">
    <div class="col">
      <label for="city">Enter the name of any city:</label>
      <input type="text" class="form-control" name="city">
    </div>
    <div class="col">
      <label for="person">Enter the name of any real person:</label>
    	<input type="text" class="form-control" name="person">
    </div>
  </div>
  <div class="row">
    <div class="col">
      <label for="hobby">Enter professional endeavor or hobby:</label>
    	<input type="text" class="form-control" name="hobby">
    </div>
    <div class="col">
      <label for="livingThing">Enter any type of living thing:</label>
    	<input type="text" class="form-control" name="livingThing">
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <label for="kindWords">Say something nice to someone:</label>
      <textarea class="form-control" name="kindWords" rows="3" cols="20">
      </textarea>
    </div>
  </div>
  <p><em>Send and show a friend</em></p>
  <button class="btn btn-light" type="submit">Send</button>
</form>
</div>
</body>
</html>