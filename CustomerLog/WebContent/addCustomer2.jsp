<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">
			
	#section{
				width: 1000px;
				text-align:center;
				padding: 15px;
				
			}
</style>

</head>
<body>
		<%@include file="header.jsp" %>
		<%@include file="menu.jsp" %>
	<form action="Register2" method="post">
		<div id="section">
		<fieldset>
			<legend>Customer Details</legend>
				<table border="0">
				
				<tr>
					<td>First Name*:</td>
					<td><input type="text" name="fName" size="16"></td>
					<td>Last Name*:</td>
					<td><input type="text" name="lName" size="16"></td>
				</tr>
				
				
				<tr>
					<td>Mobile No*:</td>
					<td><input type="text" name="mobile" size="16"></td>
					<td>Telephone No:</td>
					<td><input type="text" name="telephone" size="16"></td>
				</tr>
				
				
				<tr>
					<td>DOB*:</td>
					<td><input type="date" name="dob" size="16"></td>
					<td>Gender*:</td>
					<td>
						<select name="gender">
							<option>Female</option>
							<option>Male</option>
							<option>Other</option>
						</select>
					</td>
					
				</tr>
				<tr>
					<td>Email ID*:</td>
					<td><input type="text" name="uID" size="16"></td>
					<td>Upload your Photo:</td>
					<td><input type="file" name="filename"></td>
				</tr>
				<tr>
					<td>Password*:</td>
					<td><input type="password" name="passwrd" size="16"></td>
					<td>Confirm Password*:</td>
					<td><input type="password" name="passwrd" size="16"></td>
				</tr>
				<tr>

					<td><label for="rAdd">Present Address*:</label></td>
					<td>
						<textarea id="rAdd" name="Praddress" rows="2" cols="17" placeholder="Enter your present address"></textarea>
					</td>
					<td>Pin No*:</td>
					<td><input type="text" name="Prpin" size="16"></td>
				</tr>
				
				<tr>

					<td><label for="rAdd">Permanent Address:</label></td>
					<td>
						<textarea id="rAdd" name="Paddress" rows="2" cols="17" placeholder="Enter your permanent address"></textarea>
					</td>
					<td>Pin No:</td>
					<td><input type="text" name="Ppin" size="16"></td>
				</tr>
				
				<tr>
					<td>Office Address*</td>
					<td><textarea id="oAdd" name="Oaddress" rows="2" cols="17" placeholder="Enter your office address"></textarea></td>
					<td>Pin No*:</td>
					<td><input type="text" name="Opin" size="16"></td>
				</tr>
				
				<tr>
					<td>Company Name*:</td>
					<td><input type="text" name="company" size="16"></td>
					<td>Designation*:</td>
					<td><input type="text" name="designation" size="16"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="right">State*:
						<select name="state">
							<option>Bihar</option>
							<option>U.P.</option>
							<option>Kolkta</option>
							<option>MP</option>
							<option>AP</option>
						</select>
					</td>	
					<td colspan="3" align="left">Country*:
						<select name="country">
							<option>USA</option>
							<option>UK</option>
							<option>Rusia</option>
							<option>China</option>
							<option>England</option>
							<option>Japan</option>
							<option>India</option>
							<option>Nepal</option>
							<option>Pak</option>
						</select>
					</td>
					<td></td>
					<td></td>
				</tr>
					
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