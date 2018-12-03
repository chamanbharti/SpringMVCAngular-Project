<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">
	
	#section{
				width: 800px;
				float: left;
				padding: 10px;
				text-align: center;
				border-collapse:collapse;
			}
	
</style>
</head>

<body>
	
		<%@include file="header.jsp" %>
		<%@include file="menu.jsp" %>
			<p id="demo"></p>
		<div id="section">
		<table border="1" align="center" width="100%">
		
				<tr>
					<th>Image</th>
					<th>Name</th>
					<th>Designation</th>
					<th>View</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
							<tr>
								<td>
									<img src="bharti.jpg" alt="Mountain View" style="width:100px;height:30px" align="bottom">
								</td>
								<td></td>
								<td></td>
								<td><a href="view2.jsp"><img alt="click to view" src="./images/view.png" width="50" height="30"></a></td>
								<td><a href="edit.jsp"><img alt="clic to edit" src="./images/edit.png" width="50" height="30"></a></td>
								<td><button onclick="myFunction()"><img alt="clic to edit" src="./images/delete.jpg" width="50" height="30"></button></td>
							</tr>
		</table>
	</div>
	<%@include file="footer.jsp" %>	
</body>
</html>