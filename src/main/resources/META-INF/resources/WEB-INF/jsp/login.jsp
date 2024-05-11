<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<c:if test="${not empty message }">
<div align="center" style="color: red;">
		<b><h2><c:out value="${message}" /></h2></b>
	</div> 

</c:if>

<c:if test="${not empty errorMessage}">
<div align="center" style="color: red;">
		<b><h2><c:out value="${errorMessage}" /></h2></b>
	</div>
	

</c:if>


	
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 500px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	margin-bottom: 20px;
}

label {
	display: block;
	margin-bottom: 5px;
}

input[type="text"], input[type="email"], input[type="password"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
	box-sizing: border-box;
}

input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Login</h2>
		
		<form name="createUber" action="/login" method="post">
			 <label
				for="email">Email</label> <input type="email" id="username"
				name="username" placeholder="Enter the Email" required> <label
				for="password">Password</label> <input type="password" id="password"
				name="password" placeholder="Enter the password" required> <input
				type="submit" value="Login">
				<input name="_csrf" type="hidden" value="${_csrf.token}">
				<a href="userRegistartionPage" >SignUp</a>
		</form>
	</div>
</body>
</html>
