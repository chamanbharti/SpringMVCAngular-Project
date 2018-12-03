<%@page import="chaman.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="./js/ajax.js"></script>
<script type="text/javascript" src="./js/JavaScript.js"></script>
<style>
	#section{
				background-color: white;
				width: 1000px;
				text-align:center;
				padding: 15px;
				
			}
			
			#txt{color: white;background-color: green;}
	
</style>
</head>
<body >
		<%@include file="header.jsp" %>
		<%@include file="menu.jsp" %>
		
	<form action="UpdateCustomer" enctype="multipart/form-data" method="post">
		<%
			Customer cust=(Customer)request.getAttribute("custList");
		%>
		<div id="section">
		<fieldset>
			<legend>Edit Your Details</legend>
			<table border="0">
			<input type="hidden" name="custId" value="<%=cust.getCustId() %>" required>
			<tr>
					<td>First Name*</td>
					<td><input type="text" name="fname" size="16" value="<%=cust.getFirstName() %>" required></td>
					<td>Last Name*</td>
					<td><input type="text" name="lname" size="16" value="<%=cust.getLastName() %>" required></td>
			</tr>
			<tr>
					<td>Mobile NO*</td>
					<td><input type="text" name="mobile" size="16" maxlength="10" value="<%=cust.getMobileNo() %>" required></td>
					<td>Telephone NO</td>
					<td><input type="text" name="telephone" size="16" maxlength="12" value="<%=cust.getTelephoneNO() %>" required></td>
			</tr>
			
			<tr>
					<td>DOB*:</td>
					<td><input type="date" name="dob" size="16" value="'<%=cust.getDob() %>'" required></td>
					<td>Gender*:</td>
					<td>
						<select name="gender">
							<option><%=cust.getGender() %></option>
							<option>Female</option>
							<option>Male</option>
							<option>Lesbian</option>
							<option>Gay</option>
							<option>Other</option>
						</select>
					</td>
					
			</tr>
			
			<tr>
				<td>Email ID*</td>
				<td><input type="email" name="email" size="16" value="<%=cust.getEmailId() %>" required></td>
				<%-- <td>Photo:</td>
				<td rowspan="0"><img alt="click to view" src=<%=cust.getCustomerIcon()%> width="100" height="50"></td>
				<td>Change Photo:</td>
				<td><input type="file" name="filename" ></td> --%>
			</tr>
			
			<tr>

					<td><label for="rAdd">Present Address*:</label></td>
					<td>
						<textarea id="rAdd" name="Praddress" rows="2" cols="17" required><%=cust.getPrAdd()%></textarea>
					</td>
					<td>Pin No*:</td>
					<td><input type="text" name="Prpin" size="16" maxlength="6" value="<%=cust.getPrPin()%>" required></td>
			</tr>
			
			<tr>

					<td><label for="rAdd">Permanent Address:</label></td>
					<td>
						<textarea id="rAdd" name="Paddress" rows="2" cols="17" required><%=cust.getPerAdd()%></textarea>
					</td>
					<td>Pin No:</td>
					<td><input type="text" name="Ppin" size="16" maxlength="6" value="<%=cust.getPerPin()%>" required></td>
			</tr>
				
			<tr>
					<td>Office Address*</td>
					<td><textarea id="oAdd" name="Oaddress" rows="2" cols="17" required><%=cust.getOffAdd()%></textarea></td>
					<td>Pin No*:</td>
					<td><input type="text" name="Opin" size="16" maxlength="6" value="<%=cust.getOffPin()%>" required></td>
			</tr>
				
			<tr>
					<td>Company Name</td>
					<td><input type="text" name="company" size="16" value="<%=cust.getCompanyName()%>" required></td>
					<td>Designation</td>
				    <td><input type="text" name="designation" size="16" value="<%=cust.getDesignation()%>" required></td>
			</tr>		
			<table>
				<tr>
				
					<td colspan="0" align="right">Country*:
							<select name="country" id="country" onchange="showState(this);">
								<option value=""><%=cust.getCountry()%></option>
							</select>
				 	</td>
						
					<td colspan="0" align="right">State*:
							<select name="state" id="state" onchange="showCity(this);">
								<option><%=cust.getState() %></option>
							</select>
					</td>	
						
					<td colspan="0" align="left">City*:
							<select name="city" id="city">
								<option><%=cust.getCity() %></option>
							</select>
					</td>
				</tr>
			</table>
			
			
		<tr>
				<td></td>
				<td align="right"><input type="submit" value="Submit"></td>
				<td align="left"><input type="reset" value="Clear"></td>
				<td></td>
		</tr>	
		</table>
		</fieldset>	
		</div>
	</form>
	<%@include file="footer.jsp" %>
</body>
</html>