<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
	#logout{
				background-color: white;
				text-align: center;
			}
	
</style>
</head>
<body>
			<%@include file="header.jsp" %>
			<%@include file="menu.jsp" %>
			
			<form action="Logout" method="get">
			     
				<div id="logout">
					<h1>You want to exit</h1>
					 
  
<input type="button" value="delete record" onclick="msg()"/>  
					<input type="submit" name="logout" value="Logout"><br><br>
				</div>
				
			</form>
	
	
		<%@include file="footer.jsp" %>
</body>
</html>