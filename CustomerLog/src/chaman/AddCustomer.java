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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class AddCustomer extends HttpServlet{
	
	private static final String UPLOAD_DIR = "uploads";
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		//session handling
		//HttpSession session=req.getSession(false);
		
			String firstName=req.getParameter("fName");  
			String lastName=req.getParameter("lName");  
			Long mobileNo=Long.parseLong(req.getParameter("mobile"));;
			
			Long telephoneNo=Long.parseLong(req.getParameter("telephone"));; 
			String dob=req.getParameter("dob"); 
			Timestamp dobDate=formatDate(dob);
			String gender=req.getParameter("gender"); 
			String email=req.getParameter("uID");  
			String photo=req.getParameter("filename"); 
			
			//Step-I-Creating Folder for file storing
			// gets absolute path of the web application
			String applicationPath=req.getServletContext().getRealPath("");
			 // constructs path of the directory to save uploaded file
			String uploadFilePath=applicationPath+File.separator+UPLOAD_DIR;
			System.out.println("UploadFilePath="+uploadFilePath);
			// creates the save directory if it does not exists
			File fileSaveDir=new File(uploadFilePath);
			if(!fileSaveDir.exists()){
				fileSaveDir.mkdirs();
			}
			System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
			
			//Step-II-Get part using HttpServletRequest’s getPart() method
			Part filePart=req.getPart("filename");
			//sTEP-III- Extract image name from content-disposition header of part
			String imageName = getFileName(filePart);
			filePart.write(uploadFilePath + File.separator + imageName);
			System.out.println( uploadFilePath + File.separator + imageName + " File uploaded successfully!");
			
			String pass=req.getParameter("passwrd");
			String prAddress=req.getParameter("Praddress");
			Long prPin=Long.parseLong(req.getParameter("Prpin"));
			String perAdd=req.getParameter("Peraddress");
			Long perPin=Long.parseLong(req.getParameter("Perpin"));
			String offAddress=req.getParameter("Oaddress");
			Long offPin=Long.parseLong(req.getParameter("Opin"));
			String cName=req.getParameter("company");
			String designation=req.getParameter("designation");
			String state=req.getParameter("state");
			String country=req.getParameter("country");
			String city=req.getParameter("city");
			
			PreparedStatement ps;
			ResultSet rs;
			Connection con;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","chaman_bharti","@chaman#2012");  
				 
				
				ps=con.prepareStatement("insert into customer values(CUSTOMER_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  
				
				ps.setString(1,firstName);  
				ps.setString(2,lastName);  
				ps.setLong(3, mobileNo);
				ps.setLong(4, telephoneNo);
				ps.setTimestamp(5, dobDate);
				ps.setString(6, imageName);
				ps.setString(7, gender);
				ps.setString(8, email);
				ps.setString(9, pass);
				ps.setString(10, prAddress);
				ps.setLong(11, prPin);
				ps.setString(12, perAdd);
				ps.setLong(13, perPin);
				ps.setString(14, offAddress);
				ps.setLong(15, offPin);
				ps.setString(16, cName);
				ps.setString(17, designation);
				//ps.setString(18, "District");
				ps.setString(18, city);
				ps.setString(19, state);
				ps.setString(20, country);
				
				//ps.executeUpdate();
				          
				int i=ps.executeUpdate();  
				if(i>0)  {
					RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
					rd.forward(req, resp);
				}else{
					RequestDispatcher rd=req.getRequestDispatcher("addCustomer.jsp");
					rd.forward(req, resp);
				}
				
			}
			catch(Exception e){e.printStackTrace();}
		
	}
	
	private String getFileName(Part part) {
		final String partHeader = part.getHeader("content-disposition");
		System.out.println("***** partHeader: " + partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	
	private Timestamp formatDate(String dob){
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
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
