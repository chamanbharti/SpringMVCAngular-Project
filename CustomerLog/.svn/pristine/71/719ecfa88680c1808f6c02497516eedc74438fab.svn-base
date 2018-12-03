package chaman;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StateHandler extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		StringBuilder stateList=new StringBuilder("<option>Select State</option>");
		
		 String countryId=request.getParameter("counrtyId");  
		 try{
			 Class.forName("oracle.jdbc.driver.OracleDriver");  
			 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","chaman_bharti","@chaman#2012");  
			 Statement stmt = con.createStatement();  
			 ResultSet rs = stmt.executeQuery("Select * from state where countryid='"+countryId+"' ");  
			 
			 while(rs.next()){
				 stateList=stateList.append("<option value='"+rs.getInt("STATEID")+"'>"+rs.getString("STATENAME")+"</option>\n");  
			 } 
			 
			 response.getWriter().println(stateList); 
		 }
		 catch(Exception e){
		     System.out.println(e);
		 }

	}
	
}
