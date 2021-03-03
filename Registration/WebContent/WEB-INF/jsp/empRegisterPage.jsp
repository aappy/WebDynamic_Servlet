<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1> Please Register... </h1>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body bgcolor="green">

<div align="center">

<form action="<%= request.getContextPath()%>/register" method="post">
		<table>
			 <tr>
			 	<td>First Name:</td>
				<td><input type="text" name="firstName"></td>
			 </tr>			 
			  <tr>
			 	<td>Last Name:</td>
				<td><input type="text" name="lastName"></td>
			 </tr>	 
			  <tr>
			 	<td>User Name:</td>
				<td><input type="text" name="username"></td>
			 </tr>
			  <tr>
			 	<td>Password:</td>
				<td><input type="password" name="password"></td>
			 </tr>
			  <tr>
			 	<td>Address:</td>
				<td><input type="text" name="address"></td>
			 </tr>
			  <tr>
			 	<td>Contact:</td>
				<td><input type="text" name="contact"></td>
			 </tr>
		</table>
		<input type="submit" value="Submit">
	</form>
</div>
</body>
</html>