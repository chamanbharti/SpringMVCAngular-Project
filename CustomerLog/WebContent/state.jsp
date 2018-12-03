<%@page import="java.sql.*"%>
<%
String country=request.getParameter("count");  
 String buffer="<select name='state' onchange='showCity(this.value);'><option value='-1'>Select</option>";  
 try{
 Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();  
 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","chaman_bharti","@chaman#2012");  
 Statement stmt = con.createStatement();  
 ResultSet rs = stmt.executeQuery("Select * from state where countryid='"+country+"' ");  
   while(rs.next()){
   buffer=buffer+"<option value='"+rs.getString(1)+"'>"+rs.getString(3)+"</option>";  
   }  
 buffer=buffer+"</select>";  
 response.getWriter().println(buffer); 
 }
 catch(Exception e){
     System.out.println(e);
 }

 %>