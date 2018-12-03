package chaman;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UpdateCustomer extends HttpServlet{
	
	private static final String UPLOAD_DIR = "uploads";
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		String Id=req.getParameter("custId");
		long custid=Long.parseLong(Id);
		String firstName=req.getParameter("fname");  
		String lastName=req.getParameter("lname");  
		Long mobileNo=Long.parseLong(req.getParameter("mobile"));;
		Long telephoneNo=Long.parseLong(req.getParameter("telephone"));; 
		String dob=req.getParameter("dob"); 
		Timestamp dobDate=formatDate(dob);
		String gender=req.getParameter("gender"); 
		String email=req.getParameter("email");  
		String prAddress=req.getParameter("Praddress");
		Long prPin=Long.parseLong(req.getParameter("Prpin"));
		String pAddress=req.getParameter("Paddress");
		Long pPin=Long.parseLong(req.getParameter("Ppin"));
		String offAddress=req.getParameter("Oaddress");
		Long offPin=Long.parseLong(req.getParameter("Opin"));
		String cName=req.getParameter("company");
		String designation=req.getParameter("designation");
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		String country=req.getParameter("country");
		
		PreparedStatement ps;
		ResultSet rs;
		Connection con;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","chaman_bharti","@chaman#2012");  
			 
			
			ps=con.prepareStatement("update customer set FIRST_NAME=?,LAST_NAME=?,MOBILE_NO=?,TELEPHONE_NO=?,DOB=?,GENDER=?,EMAIL_ID=?,PR_ADD=?,PR_PIN=?,PER_ADD=?,PER_PIN=?,OFF_ADD=?,OFF_PIN=?,COMP_NAME=?,DESIGNATION=?,CITY=?,STATE=?,COUNTRY=? where cust_id=?");  
			
			ps.setString(1,firstName);  
			ps.setString(2,lastName);  
			ps.setLong(3, mobileNo);
			ps.setLong(4, telephoneNo);
			ps.setTimestamp(5, dobDate);
			ps.setString(6, gender);
			ps.setString(7, email);
			ps.setString(8, prAddress);
			ps.setLong(9, prPin);
			ps.setString(10, pAddress);
			ps.setLong(11, pPin);
			ps.setString(12, offAddress);
			ps.setLong(13, offPin);
			ps.setString(14, cName);
			ps.setString(15, designation);
			ps.setString(16, city);
			ps.setString(17, state);
			ps.setString(18, country);
			ps.setLong(19, custid);
			          
			int i=ps.executeUpdate();  
			if(i>0)  {
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}else{
				RequestDispatcher rd=req.getRequestDispatcher("edit.jsp");
				rd.forward(req, resp);
			}
			
		}
		catch(Exception e){e.printStackTrace();}
		
	}
	
	private Timestamp formatDate(String dob){
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateInString = "7-Jun-2013";
		Timestamp dobTimeStamp=null;
		try {
			Date date = formatter.parse(dob);
			System.out.println(date);
			formatter.format(date);
			System.out.println(formatter.format(date));
			dobTimeStamp=new Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dobTimeStamp;
	}
	
}
