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

public class Register extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	/**Process the HTTP Get request*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			Connection con=null;
			ResultSet rs;
		 //get the variables entered in the form
		  String uId = req.getParameter("userId");
		  String fname = req.getParameter("firstname");
		  String sname = req.getParameter("surname");
		  String address1 = req.getParameter("address1");
		  String address2 = req.getParameter("address2");
		  String town = req.getParameter("town");
		  String county = req.getParameter("country");
		  String zipcode = req.getParameter("zipcode");
		  //String dob = req.getParameter("dob");
		  
		  try{
			  // Load the database driver
			  Class.forName("oracle.jdbc.driver.OracleDriver");
				
			  // Get a Connection to the database
			  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","chaman_bharti","@chaman#2012");
			  //Add the data into the database
			  String sql = "insert into register3 values (?,?,?,?,?,?,?,?)";
			  PreparedStatement ps=con.prepareStatement(sql);
			  ps.setString(1, uId);
			  ps.setString(2, fname);
			  ps.setString(3, sname);
			  ps.setString(4, address1);
			  ps.setString(5, address2);
			  ps.setString(6, town);
			  ps.setString(7, county);
			  ps.setString(8, zipcode);
			  //ps.setString(9, dob);
			  ps.executeUpdate();
			  //int numRowsChanged = ps.executeUpdate();
			  // show that the new account has been created
			  out.println(" Hello : ");
			  out.println(" '"+fname+"'");
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
