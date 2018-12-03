package chaman;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class EditCustomer extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			 PreparedStatement ps;
			 ResultSet rs;
			 Connection con;
			 String Id=req.getParameter("custId");
			 //long custid=Long.parseLong(Id);
			 int custid=Integer.parseInt(Id);
			 Customer cust=null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","chaman_bharti","@chaman#2012");
				
				ps=con.prepareStatement("select * from customer where cust_id=?");
				ps.setLong(1, custid);
				//System.out.println("connection established successfully...!!");  

				rs=ps.executeQuery();
				while(rs.next()){
					cust=new Customer();
					
					//System.out.println(rs.getInt("custid"));
					//long custId=rs.getLong("CUST_ID");
					int custId=rs.getInt("CUST_ID");
					cust.setCustId(custId);
					String firstName = rs.getString("FIRST_NAME");
					cust.setFirstName(firstName);
					String lastName = rs.getString("LAST_NAME");
					cust.setLastName(lastName);
					long mobileNo=rs.getLong("MOBILE_NO");
					cust.setMobileNo(rs.getLong("MOBILE_NO"));
					long telephoneNo=rs.getLong("TELEPHONE_NO");
					cust.setTelephoneNO(telephoneNo);
					Date dob=rs.getDate("DOB");
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");  
				    String dobDate= formatter.format(dob);
					cust.setDob(dobDate);
					String customerIcon=rs.getString("CUSTOMERICON");
					cust.setCustomerIcon("./uploads/"+customerIcon);
					//cust.setCustomerIcon(customerIcon);
					String gender=rs.getString("GENDER");
					cust.setGender(gender);
					String emailId=rs.getString("EMAIL_ID");
					cust.setEmailId(emailId);
					String password=rs.getString("PASSWORD");
					cust.setPassword(password);
					String prAdd=rs.getString("PR_ADD");
					cust.setPrAdd(prAdd);
					long prPin=rs.getLong("PR_PIN");
					cust.setPrPin(prPin);
					String perAdd=rs.getString("PER_ADD");
					cust.setPerAdd(perAdd);
					long perPin=rs.getLong("PER_PIN");
					cust.setPerPin(perPin);
					String offAdd=rs.getString("OFF_ADD");
					cust.setOffAdd(offAdd);
					long offPin=rs.getLong("OFF_PIN");
					cust.setOffPin(offPin);
					String companyName=rs.getString("COMP_NAME");
					cust.setCompanyName(companyName);
					String designation=rs.getString("DESIGNATION");
					cust.setDesignation(designation);
					
					//Fetching countryname based on countryid
					StringBuilder countryList=null;
					String country=rs.getString("COUNTRY");
					int countryId=Integer.parseInt(country);
					PreparedStatement prs=con.prepareStatement("select * from country where countryId=?");
					prs.setInt(1, countryId);
					ResultSet rss=prs.executeQuery();
					while(rss.next()){
						countryList=new StringBuilder("<option value='"+countryId+"' selected>"+rss.getString("COUNTRYNAME")+"</option>\n");
					}
					//Fetching all countryname 
					Statement stmt = con.createStatement();
					rss = stmt.executeQuery("Select * from country");  
					while(rss.next()){
						 countryList=countryList.append("<option value='"+rss.getInt("COUNTRYID")+"'>"+rss.getString("COUNTRYNAME")+"</option>\n");  
					} 
					cust.setCountry(countryList.toString());
					
					//Fetching statename based on stateid
					StringBuilder stateList=null;
					String state=rs.getString("STATE");
					int stateId=Integer.parseInt(state);
					PreparedStatement ps2=con.prepareStatement("select * from state where stateId=?");
					ps2.setInt(1, stateId);
					ResultSet rs1=ps2.executeQuery();
					while(rs1.next()){
						//cust.setState(rs2.getString("STATENAME"));
						stateList=new StringBuilder("<option value='"+stateId+"' selected>"+rs1.getString("STATENAME")+"</option>\n");
					}
					//Fetching all statename 
					Statement stmt2=con.createStatement();
					rs1=stmt2.executeQuery("Select * from state");
					while(rs1.next()){
						stateList=stateList.append("<option value='"+rs1.getInt("STATEID")+"'>"+rs1.getString("STATENAME")+"</option>\n");
					}
					 cust.setState(stateList.toString());
					 
					//Fetching cityname based on cityid
					StringBuilder cityList=null;
					String city=rs.getString("CITY");
					int cityId=Integer.parseInt(city);
					PreparedStatement ps1=con.prepareStatement("select * from city where cityId=?");
					ps1.setInt(1, cityId);
					ResultSet rs2=ps1.executeQuery();
					while(rs2.next()){
						//cust.setCity(rs1.getString("CITYNAME"));
						cityList=new StringBuilder("<option value='"+cityId+"' selected>"+rs2.getString("CITYNAME")+"</option>\n");
					}
					//Fetching all cityname 
					Statement stmt3=con.createStatement();
					rs2=stmt3.executeQuery("Select * from city");
					while(rs2.next()){
						cityList=cityList.append("<option value='"+rs2.getInt("CITYID")+"'>"+rs2.getString("CITYNAME")+"</option>\n");
					}
					 cust.setCity(cityList.toString());
					
				}
			} 
			catch (Exception e) {
				System.out.println(e);
			}
			
			if(cust!=null){
				req.setAttribute("custList", cust);
				RequestDispatcher rd=req.getRequestDispatcher("edit.jsp");
				rd.forward(req, resp);
			}else{
				RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
			}
			
			
	}

}
