<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
<script type="text/javascript">
		function validate()
		{
			uid=document.form1.uid.value;
			pwd=document.form1.pwd.value;
			
			if(uid==""||uid==null)
			{
				alert("Please Enter Your User ID"); 
				
				document.form1.uid.focus();
				return false;
			}
			
			if(pwd==""||pwd==null)
			{
				alert("Please Enter Your Password"); 
				document.form1.pwd.focus();
				return false;
			}
			return true;
		}
				
	</script>
	
</head>
<body>
		<%@include file="header.jsp" %>
	<form name="form1" method="post" action="Login" onsubmit="return validate()">
	
	<div id="container">
		
		
			<%@include file="menu.jsp" %>
				<div id="content">
						<div id="error">
							<%
							String errors=(String)request.getAttribute("error");
							if(errors ==null)
								errors="";
							
							%>
							<%=errors %>
							
						</div>
						<div id="error">
							<%
							String logout=(String)request.getAttribute("logout");
							if(logout ==null)
								logout="";
							
							%>
							<%=logout %>
							
						</div>
						
						<table border="0">
							
							<tr>
								<td><b>User ID:</b></td>
								<td><input type="text" name="uid">
							</tr>
							<tr>
								<td><b>Password:</b></td>
								<td><input type="password" name="pwd">
							</tr>
							<tr>
								<center>
								<td align="right"><input type="submit" value="Login"></td></center>
								<td align="right"><input type="reset" name="Reset"></td>
								
							</tr>
							<tr>
								<td></td>
								<td><b><a href="addCustomer.jsp">SignUp</a></b></td>
							</tr>
					</table>
				</div>
			
	</div>
	</form>
	
		<%@include file="footer.jsp" %>
</body>
</html>