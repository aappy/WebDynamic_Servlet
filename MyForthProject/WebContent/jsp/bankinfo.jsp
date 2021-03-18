<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="green">
	<form method="get" action="/MyForthProject/BankInfoServlet">

		<h3>
			<font color="blue"><b>Bank Information</b></font>
		</h3>
		<table>
			<tr>
				<td><label for="bankName">Bank Name</label></td>
				<td><select id="bankName" name="bankName">
						<%
							System.out.println("bankName  asda1" + request.getParameter("bankName"));
						if (request.getParameter("bankName") != "") {
						%>
						<option value="<%=request.getParameter("bankName")%>">
							<%=request.getParameter("bankName") != null ? request.getParameter("bankName") : ""%>">
						</option>
						<%
							} else {
						%>
						<option value="">Please Select an option</option>

						<%
							}
						%>
						<option value="BankOfAmerica">Bank of America</option>
						<option value="USBank">US Bank</option>
						<option value="Wellsfargo">Wellsfargo</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="accountNumber">Account</label></td>
				<td><input type="text" name="accountNumber" id="accountNumber"
					value="<%=request.getParameter("accountNumber") != null ? request.getParameter("accountNumber") : ""%>"></td>
			</tr>
			<tr>
				<td><label for="ssn">SSN</label></td>
				<td><input type="text" name="ssn" id="ssn"
					value="<%=request.getParameter("ssn") != null ? request.getParameter("ssn") : ""%>"></td>
			</tr>
		</table>
		<br> <br> <input type=submit name="submit" value="submit" />
	</form>

	<%
		Object obj = request.getAttribute("BankPageError");
	String errors = "";
	if (obj != null) {
		errors = (String) obj;
	}
	%>
	<%=errors%>

</body>
</html>