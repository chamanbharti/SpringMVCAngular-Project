<%@page import="chaman.Customer"%>
<%@page import="com.sun.javafx.scene.control.skin.CustomColorDialog"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<style type="text/css">
	
	#section{
				width: 80%;
				float: left;
				padding: 10px;
			}
			td{
				 width: 20%;
				 text-shadow:green;
				 font-size: medium;
				 font-weight: bold;
				 color:olive;
				}
	
</style>
</head>
<body>
	
		<%@include file="header.jsp" %>
		<%@include file="menu.jsp" %>
	 	 <%
	 	 	Customer cust=(Customer)request.getAttribute("custList");
	 	 %>
	 	 <div id="section">
		<fieldset>
			<legend>Customer Details</legend>
				<table border="0">
				
				<tr>
					<td>Customer's Icon:</td>
					<td>First Name:</td>
					<td><%=cust.getFirstName() %></td>
					<td>Last Name:</td>
					<td><%=cust.getLastName() %></td>
					<%--
					<td rowspan="10"><%=cust.getCustomerIcon() %></td>
					<td>Customer ID:</td>
					<td><%=cust.getCustId() %></td>
					 --%>
					
				</tr>
				
				<tr>
					<td rowspan="9"><img alt="click to view" src=<%=cust.getCustomerIcon()%> width="150" height="250"></td>
					<%-- 
					<td rowspan="9"><%=cust.getCustomerIcon() %></td>
					<td>First Name:</td>
					<td><%=cust.getFirstName() %></td>
					<td>Last Name:</td>
					<td><%=cust.getLastName() %></td>--%>
				</tr>
				
				
				<tr>
					<td>Mobile No:</td>
					<td><%=cust.getMobileNo() %></td>
					<td>Telephone No:</td>
					<td><%=cust.getTelephoneNO() %></td>
				</tr>
				
				<tr>
					 <td>DOB:</td>
					 <td><%=cust.getDob() %></td> 
					 <td>Gender:</td>
					 <td><%=cust.getGender() %></td>
					
				</tr>
				<tr>
					<td>Email ID:</td>
					<td><%=cust.getEmailId() %></td>
					<td>Password:</td>
					<td><%=cust.getPassword() %></td>
				</tr>
				
				<tr>

					<td>Present Address:</td>
					<td><%=cust.getPrAdd() %></td>
					<td>Pin No:</td>
					<td><%=cust.getPrPin() %></td>
				</tr>
				
				<tr>

					<td>Permanent Address:</td>
					<td><%=cust.getPerAdd() %></td>
					<td>Pin No:</td>
					<td><%=cust.getPerPin()%></td>
				</tr>
				
				<tr>
					<td>Office Address</td>
					<td><%=cust.getOffAdd() %></td>
					<td>Pin No:</td>
					<td><%=cust.getOffPin() %></td>
				</tr>
				
				<tr>
					<td>Company Name:</td>
					<td><%=cust.getCompanyName() %></td>
					<td>Designation:</td>
					<td><%=cust.getDesignation() %></td>
				</tr>
				
				<tr>
					<td>Country:</td>
					<td><%=cust.getCountry() %></td>
					<td>State:</td>	
					<td><%=cust.getState() %></td>
					
					<td>City:</td>
					<td><%=cust.getCity()%></td>
					
				</tr>
					
				</table>
		</fieldset>	
		</div>
	
	<%@include file="footer.jsp" %>
</body>
</html>