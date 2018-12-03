
package chaman;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteCustomer extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
			 PreparedStatement ps;
			 ResultSet rs;
			 Connection con;
			String Id=req.getParameter("custId");
			//long custid=Long.parseLong(Id);
			int custid=Integer.parseInt(Id);
			//Customer cust=null;
			//Session
			HttpSession session=req.getSession(false);
			
			if(session==null){
				RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
			}else{
				
				   String user_id=(String)session.getAttribute("user_id");
				   
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","chaman_bharti","@chaman#2012");
				
				ps=con.prepareStatement("delete from customer where cust_id=?");
				ps.setLong(1, custid);
				//System.out.println("connection established successfully...!!");  

				//rs=ps.executeQuery();
				int i=ps.executeUpdate();
				
				if(i>0){
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
				}else{
					RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
					rd.forward(req, resp);
				}
				
				
				
			} 
			catch(Exception e){
				e.printStackTrace();
			}
			
	  }	
			
	}		 
}
