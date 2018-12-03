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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PreparedStatement ps;
		ResultSet rs;
		Connection con;
		boolean result=false;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//Login servlet
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","chaman_bharti","@chaman#2012");
				
				String userId=request.getParameter("uid");
				String pass=request.getParameter("pwd");
				
				ps=con.prepareStatement("select user_id from login2 where user_id = ? and password = ?");
				ps.setString(1, userId);
				ps.setString(2, pass);
				System.out.println("connection established successfully...!!");  

				rs=ps.executeQuery();
				while(rs.next()){
					String ruserId = rs.getString("user_id");
					if(ruserId.length()>0)
						result=true;
				}
				
				if(result){
					List<Customer> custList=new ArrayList<Customer>();
					//session handling
					HttpSession session=request.getSession();
					session.setAttribute("userId",userId);
					
					ps=con.prepareStatement("select * from customer");
					//System.out.println("connection established successfully...!!");  

					rs=ps.executeQuery();
					
					while(rs.next()){
						Customer cust=new Customer();
						
						long custId=rs.getLong("CUST_ID");
						cust.setCustId(custId);
						String firstName = rs.getString("FIRST_NAME");
						cust.setFirstName(firstName);
						String lastName = rs.getString("LAST_NAME");
						cust.setLastName(lastName);
						
						//String customerIcon=rs.getString("CUSTOMERICON");
						//cust.setCustomerIcon(customerIcon);
						String gender=rs.getString("GENDER");
						cust.setGender(gender);
						
						String companyName=rs.getString("COMP_NAME");
						cust.setCompanyName(companyName);
						String designation=rs.getString("DESIGNATION");
						cust.setDesignation(designation);
						
						String custIcon=rs.getString("CUSTOMERICON");
						cust.setCustomerIcon("./uploads/"+custIcon);
						
						custList.add(cust);
					}
					System.out.println(custList);
					request.setAttribute("custList", custList);
					RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
					rd.forward(request, response);
					
				}else{
					request.setAttribute("error", "<h1><b>Sorry UserName or Password is error!</b></h1>");
					RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
				
				
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
