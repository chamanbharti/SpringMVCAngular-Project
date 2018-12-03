<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
	#delete{
				background-color: white;
				text-align: center;
			}
	#header{
				background-color: green;
				color: white;
				text-align: center;
				padding: 10px;
			}
	#footer{
				background-color: green;
				color: white;
				clear:both;
				text-align: center;
				padding: 10px;
			}
</style>
</head>
<body>
		
		<%@include file="header.jsp" %>
		<%@include file="menu.jsp" %>
		
	<form action="DeleteCustomer" method="get">
		<div id="delete">
			<!-- <script type="text/javascript">
				function myFunction(){
					var x;
					if(confirm("You want to delete!")==true){
						x="You have deleted!";
					}
					else{
						alert("You have not deleted!");
					}
					document.getElementById("demo").innerHTML=x;	
				}
			</script> -->
			
			<h1>You Want to Delete</h1>
			<button onclick="msg(custId)">Delete</button>
			<p id="demo"></p>
			
		</div>
	</form>
	<%@include file="footer.jsp" %>
</body>
</html> 