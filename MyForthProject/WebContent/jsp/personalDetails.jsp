<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="green">
<%
	Object obj = request.getAttribute("PersonalPageError");
	String errors = "";
	if(obj != null) {
		errors = (String) obj;
	}
%>
<%= errors %>

	<form method="get" action="/MyForthProject/personalDetailsServlet">

		<h3><font color="blue"><b>Personal Information</b></font></h3>

		<table>
			<tr>
				<td><label for="firstname">First Name</label></td>
				<td><input type="text" name="firstname" id="firstname" value="<%= request.getParameter("firstname") != null ? request.getParameter("firstname") : ""%>"></td>
			</tr>
			<tr>
				<td><label for="lastname">Last Name</label></td>
				<td><input type="text" name="lastname" id="lastname" value="<%= request.getParameter("lastname") != null ? request.getParameter("lastname") : "" %>"></td>
			</tr>
			<tr>
				<td><label for="middlename">Middle Name</label></td>
				<td><input type="text" name="middlename" id="middlename" value="<%= request.getParameter("middlename") != null ? request.getParameter("firstname") : ""%>"></td>
			</tr>
			<tr>
				<td><label for="gender">Gender </label></td>
		
					<td><input type="radio"  id="male" name="gender" value="male">
					<label for="male">Male</label>
					<input type="radio"  id="female" name="gender" value="female">
					<label for="female">Female</label>
				</td>
			</tr>
		</table>
		<br> <br> <input type=submit name="submit" value="submit" />
	</form>

</body>
</html>