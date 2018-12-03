package chaman;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class SearchCustomer2 extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
         PreparedStatement ps;
		 ResultSet rs;
		 Connection con;
		 Customer cust=null;
		 String mobileNo=request.getParameter("mobileNo");
		 long mobile=0;
		 
		 if(mobileNo.equals("")){
			 out.println("Please Enter valid Mobile NO.");
			 RequestDispatcher rd=request.getRequestDispatcher("/search.jsp");
			 rd.include(request, response);
		 }
		 else{// Check valid input
			 
			 try{
				  mobile=Long.parseLong(mobileNo);
				  
				  try{
					  	Class.forName("oracle.jdbc.driver.OracleDriver");
				        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","chaman_bharti","@chaman#2012");
				        
				        ps=con.prepareStatement("select * from customer where mobile_no=?");
				        
				        ps.setLong(1, mobile);
				        
				        rs=ps.executeQuery();
				        out.println(
				                "<fieldset><legend>"
				                + "<font face=Couriercolor=red>"+"Customer Record according to mobile number"+"</font>"
				        + "</legend><table border=1> " );
				                // Display Table Column name
				                ResultSetMetaData rsmd=ps.getMetaData();
				                int totalColumn=rsmd.getColumnCount();
				                    out.println("<tr>" );
				                for(int i=1;i<=totalColumn;i++)
				                  {           
				                    out.println("<th>"+rsmd.getColumnName(i)+"</th>" );
				                  }
				                  out.println("</tr>" );
				                  
				                  // Display Serached Record
				                  while(rs.next())
				                  {
					                  out.println("<tr>" );
					                  out.println("<td>"+rs.getInt(1)+"</td>" );  
					                  out.println("<td>"+rs.getString(2)+"</td>" );
					                  out.println("<td>"+rs.getString(3)+"</td>" );
					                  out.println("<td>"+rs.getLong(4)+"</td>" );
					                  out.println("<td>"+rs.getLong(5)+"</td>" );
					                  out.println("<td>"+rs.getDate(6)+"</td>" );
					                  out.println("<td>"+rs.getString(7)+"</td>" );
					                  out.println("<td>"+rs.getString(8)+"</td>" );
					                  out.println("<td>"+rs.getString(9)+"</td>" );
					                  out.println("<td>"+rs.getString(10)+"</td>" );
					                  out.println("<td>"+rs.getString(11)+"</td>" );
					                  out.println("<td>"+rs.getString(12)+"</td>" );
					                  out.println("<td>"+rs.getString(13)+"</td>" );
					                  out.println("<td>"+rs.getLong(14)+"</td>" );
					                  out.println("<td>"+rs.getString(15)+"</td>" );
					                  out.println("<td>"+rs.getLong(16)+"</td>" );
					                  out.println("<td>"+rs.getString(17)+"</td>" );
					                  out.println("<td>"+rs.getLong(18)+"</td>" );
					                  out.println("<td>"+rs.getString(19)+"</td>" );
					                  out.println("<td>"+rs.getString(20)+"</td>" );
					                  out.println("<td>"+rs.getString(21)+"</td>" );
					                  out.println("</tr>" );          
				                  }
				                  out.println("</table></fieldset>" );
				                  out.println("<BR>" );
				                  RequestDispatcher rd = 
				                  request.getRequestDispatcher("/search.jsp");
				                  rd.include(request, response);
				  }
				  catch(Exception e){
					  e.printStackTrace();
				  }
		}
			 catch(NumberFormatException e){
				 out.println("Please enter valid mobile no.");
			        RequestDispatcher rd = 
			        request.getRequestDispatcher("/search.jsp");
			        rd.include(request, response);
			 }
			 
		 }
		 out.close();
    }
}