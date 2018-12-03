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

	public class CityHandler extends HttpServlet{

		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			
			StringBuilder cityList=new StringBuilder("<option>Select City</option>\n");
			
			 String cityId=request.getParameter("cityId");  
			 try{
				 Class.forName("oracle.jdbc.driver.OracleDriver");  
				 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","chaman_bharti","@chaman#2012");  
				 Statement stmt = con.createStatement();  
				 ResultSet rs = stmt.executeQuery("Select * from city where stateid='"+cityId+"' ");  
				 
				 while(rs.next()){
					 cityList=cityList.append("<option value='"+rs.getInt("CITYID")+"'>"+rs.getString("CITYNAME")+"</option>\n");  
				 } 
				 
				 response.getWriter().println(cityList); 
			 }
			 catch(Exception e){
			     System.out.println(e);
			 }

		}
		
	}
