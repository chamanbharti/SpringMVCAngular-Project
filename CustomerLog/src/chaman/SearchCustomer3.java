package chaman;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class SearchCustomer3 extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
         Statement st=null;
		 ResultSet rs=null;
		 Connection con=null;
		 Customer cust=null;
		 String searchKeyword=request.getParameter("searchKeyword");
		 String searchValue=request.getParameter("searchValue");
		 String SQL="";
		  try{
			  	Class.forName("oracle.jdbc.driver.OracleDriver");
		        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","chaman_bharti","@chaman#2012");
		        
		        if(searchKeyword.equalsIgnoreCase("CustomerName")){
		        	SQL="select * from customer where first_name like '%"+searchValue+"%' OR last_name like '%"+searchValue+"%'";
		        }
		        if(searchKeyword.equalsIgnoreCase("contactNumber")){
		        	SQL="select * from customer where MOBILE_NO like '%"+searchValue+"%' OR TELEPHONE_NO like '%"+searchValue+"%'";
		        }
		        if(searchKeyword.equalsIgnoreCase("DOB")){
		        	SQL="select * from customer where DOB like '%"+searchValue+"%'";
			        
		        }
		        if(searchKeyword.equalsIgnoreCase("Email")){
		        	SQL="select * from customer where EMAIL_ID like '%"+searchValue+"%'";
			        
		        }
		        if(searchKeyword.equalsIgnoreCase("Address")){
		        	SQL="select * from customer where PR_ADD like '%"+searchValue+"%' OR PER_ADD like '%"+searchValue+"%' OR OFF_ADD like '%"+searchValue+"%'";
			        
		        }
		        if(searchKeyword.equalsIgnoreCase("PinCode")){
		        	SQL="select * from customer where PR_PIN like '%"+searchValue+"%' OR PER_PIN like '%"+searchValue+"%' OR OFF_PIN like '%"+searchValue+"%'";
			        
		        }
		        if(searchKeyword.equalsIgnoreCase("Company")){
		        	SQL="select * from customer where COMP_NAME like '%"+searchValue+"%'";
		        }
		        if(searchKeyword.equalsIgnoreCase("Designation")){
		        	SQL="select * from customer where DESIGNATION like '%"+searchValue+"%'";
			        
		        }
		        if(searchKeyword.equalsIgnoreCase("Country")){
		        	SQL="select * from customer where COUNTRY like '%"+searchValue+"%'";
			        
		        }
		        if(searchKeyword.equalsIgnoreCase("State")){
		        	SQL="select * from customer where STATE like '%"+searchValue+"%'";
			        
		        }
		        if(searchKeyword.equalsIgnoreCase("City")){
		        	SQL="select * from customer where CITY like '%"+searchValue+"%'";
			        
		        }
		        
		        st=con.createStatement();
		        rs=st.executeQuery(SQL);
		                  
              while(rs.next())
              {
            	  cust=new Customer();
            	//long custId=rs.getLong("CUST_ID");
				int custId=rs.getInt("CUST_ID");
				cust.setCustId(custId);
				String firstName = rs.getString("FIRST_NAME");
				cust.setFirstName(firstName);
				String lastName = rs.getString("LAST_NAME");
				cust.setLastName(lastName);
				long mobile_No=rs.getLong("MOBILE_NO");
				cust.setMobileNo(mobile_No);
				long telephoneNo=rs.getLong("TELEPHONE_NO");
				cust.setTelephoneNO(telephoneNo);
				Date dob=rs.getDate("DOB");
				cust.setDob(dob.toString());
				String customerIcon=rs.getString("CUSTOMERICON");
				cust.setCustomerIcon(customerIcon);
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
				String country=rs.getString("COUNTRY");
				int countryId=Integer.parseInt(country);
				PreparedStatement ps3=con.prepareStatement("select * from country where countryId=?");
				ps3.setInt(1, countryId);
				ResultSet rs3=ps3.executeQuery();
				while(rs3.next()){
					cust.setCountry(rs3.getString("COUNTRYNAME"));
				}
				
				//Fetching cityname based on cityid
				String state=rs.getString("STATE");
				int stateId=Integer.parseInt(state);
				PreparedStatement ps2=con.prepareStatement("select * from state where stateId=?");
				ps2.setInt(1, stateId);
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next()){
					cust.setState(rs2.getString("STATENAME"));
				}
				//Fetching cityname based on cityid
				String city=rs.getString("CITY");
				int cityId=Integer.parseInt(city);
				PreparedStatement ps1=con.prepareStatement("select * from city where cityId=?");
				ps1.setInt(1, cityId);
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next()){
					cust.setCity(rs1.getString("CITYNAME"));
				}
				       
              }
		}
		catch (Exception e) {
				System.out.println(e);
		}
			
		if(cust!=null){
			request.setAttribute("custList", cust);
			RequestDispatcher rd=request.getRequestDispatcher("searchResult.jsp");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
		}
    }
}