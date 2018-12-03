<%@page import="java.util.ArrayList"%>
<%@page import="chaman.Customer"%>
<%@page import="java.util.List"%>
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
				border-collapse2:collapse;
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
					<th>Icon</th>
					<th>Customer's Name</th>
					<th>Gender</th>
					<th>Company</th>
					<th>Designation</th>
					<th>View</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				
				<%
					 List<Customer> custList=(List<Customer>)request.getAttribute("custList"); 
				%>
	
				<% 
					if(!custList.isEmpty()){
					
						for(Customer c:custList){
				%>
				
							<tr>
								<td><img alt="click to view" src=<%=c.getCustomerIcon()%> width="120" height="80"></td>
								<td><%=c.getFirstName()%> <%=c.getLastName()%></td>
								<td><%=c.getGender()%></td>
								<td><%=c.getCompanyName()%></td>
								<td><%=c.getDesignation()%></td>
								<td><a href=ViewCustomer?custId=<%=c.getCustId()%>><img alt="click to view" src="./images/view.png" width="50" height="30"></a></td>
								<td><a href=EditCustomer?custId=<%=c.getCustId()%>><img alt="clic to edit" src="./images/edit.png" width="50" height="30"></a></td>
								<td><a href=DeleteCustomer?custId=<%=c.getCustId() %>><img alt="clic to edit" src="./images/delete.jpg" width="50" height="30"></a></td>
							</tr>
				<%	
						}
					}
				%>
				
		</table>
	</div>
		<%@include file="footer.jsp" %>
</body>
</html>	