package chaman;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register2 extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	/**Process the HTTP Get request*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		Connection con=null;
		ResultSet rs;
		
		String First_Name=req.getParameter("fName");  
		String Last_Name=req.getParameter("lName");  
		String Mobile_No=req.getParameter("mobile");  
		String Telephone_No=req.getParameter("telephone"); 
		//String DOB=req.getParameter("dob");  
		String Gender=req.getParameter("gender"); 
		String email=req.getParameter("uID");  
		//String photo=req.getParameter("filename"); 
		String pass=req.getParameter("passwrd");
		String Present_Address=req.getParameter("Praddress");
		String Pr_pin=req.getParameter("Prpin");
		String Permanent_Address=req.getParameter("Paddress");
		String P_pin=req.getParameter("Ppin");
		String Office_Address=req.getParameter("Oaddress");
		String O_pin=req.getParameter("Opin");
		String Company_Name=req.getParameter("company");
		String Designation=req.getParameter("designation");
		String State=req.getParameter("state");
		String Country=req.getParameter("country");
		
		  try{
			  // Load the database driver
			  Class.forName("oracle.jdbc.driver.OracleDriver");
				
			  // Get a Connection to the database
			  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","chaman_bharti","@chaman#2012");
			  //Add the data into the database
			  String sql = "insert into add_customer3 values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			  PreparedStatement ps=con.prepareStatement(sql);
			   ps.setString(1,First_Name);  
				ps.setString(2,Last_Name);  
				ps.setString(3, Mobile_No);
				ps.setString(4, Telephone_No);
				ps.setString(5, Gender);
				ps.setString(6, email);
				ps.setString(7, pass);
				ps.setString(8, Present_Address);
				ps.setString(9, Pr_pin);
				ps.setString(10, Permanent_Address);
				ps.setString(11, P_pin);
				ps.setString(12, Office_Address);
				ps.setString(13, O_pin);
				ps.setString(14, Company_Name);
				ps.setString(15, Designation);
				ps.setString(16, State);
				ps.setString(17, Country);
				
				ps.executeUpdate();
			    out.println(" Hello : ");
			    out.println(" '"+First_Name+"'");
			    ps.close();
		  }
		  catch(ClassNotFoundException e){
			  out.println("Couldn't load database driver: " + e.getMessage());
			  
		  } catch(SQLException e){
			  out.println("SQLException caught: " + e.getMessage());
			}
		  catch (Exception e){
			  out.println(e);
			  }
		  finally{
			  //always close the database connection
			  try{
				  if(con!=null)
					  con.close();
			  }
			  catch(SQLException e){
				  out.println(e);
			  }
		  }
				
	}

}
