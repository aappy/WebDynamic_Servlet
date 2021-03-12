<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Information</title>
</head>
<body bgcolor="green">
<form method="get" action="/MyForthProject/ContactInfoServlet">
<h3><font color="blue"><b>Contact Information</b></font></h3>
		<table>
			<tr>
				<td><label for="address">Address</label></td>
				<td><input type="text" name="address" id="address" value="<%= request.getParameter("address")!= null ? request.getParameter("address") : ""%>"></td>
			</tr>
			<tr>
				<td><label for="city">City</label></td>
				<td><input type="text" name="city" id="city" value="<%= request.getParameter("city")!= null ? request.getParameter("city") : ""%>"></td>
			</tr>
			<tr>
				<td><label for="state">State</label></td>
				<td><input type="text" name="state" id="state" value="<%= request.getParameter("state")!= null ? request.getParameter("state") : ""%>"></td>
			</tr>
			<tr>
				<td><label for="country">Country </label></td>
				<td><select id="country" name="country">
				<%
					System.out.println("countyry asda1"+request.getParameter("country"));
				if(request.getParameter("country") != "") 
				{ %>
					<option value="<%= request.getParameter("country")%>">
					<%= request.getParameter("country") != null ? request.getParameter("country") : "" %>
					</option>
				<% } else {%>
					<option value="">Please Select an option</option>
					
					<%} %>
							  
					  <option value="Australia">Australia</option>
					   <option value="Austria">Austria</option>
					   <option value="Bangladesh">Bangladesh</option>
					   <option value="Brazil">Brazil</option>
					   <option value="Canada">Canada</option>
					   <option value="Chile">Chile</option>
					   <option value="China">China</option>
					   <option value="Cuba">Cuba</option>
					   <option value="Denmark">Denmark</option>
					   <option value="Egypt">Egypt</option>
					   <option value="France">France</option>
					   <option value="Georgia">Georgia</option>
					   <option value="Germany">Germany</option>
					   <option value="Hawaii">Hawaii</option>
					   <option value="Hong Kong">Hong Kong</option>
					   <option value="India">India</option>
					   <option value="Iran">Iran</option>
					   <option value="Iraq">Iraq</option>
					   <option value="Ireland">Ireland</option>
					   <option value="Japan">Japan</option>
					   <option value="Malaysia">Malaysia</option>
					   <option value="Maldives">Maldives</option>
					   <option value="Nepal">Nepal</option>
					   <option value="Netherlands">Netherlands (Holland, Europe)</option>
					   <option value="New Zealand">New Zealand</option>
					   <option value="Nigeria">Nigeria</option>
					   <option value="Phillipines">Philippines</option>  
					   <option value="Russia">Russia</option>  
					   <option value="Switzerland">Switzerland</option> 
					   <option value="Thailand">Thailand</option>
					   <option value="United Kingdom">United Kingdom</option>
					   <option value="United States of America">United States of America</option>
					   <option value="Zambia">Zambia</option>
					</select></td>

			</tr>
			<tr>
				<td><label for="phoneNo">Phone</label></td>
				<td><input type="text"  name="phoneNo" id="phoneNo" value="<%= request.getParameter("phoneNo")!= null ? request.getParameter("phoneNo") : ""%>"></td>
			</tr>
		</table>
		<br> <br> <input type=submit name="submit" value="submit" />
		
		</form>
<%
	Object obj = request.getAttribute("ContactPageError");
	String errors = "";
	if(obj != null) {
		errors = (String) obj;
	}
%>
<%= errors %>

</body>
</html>