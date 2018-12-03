package chaman;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//@WebServlet(urlPatterns="/FileUploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10,//10MB
			     maxFileSize=1024*1024*50,      //50MB
			     maxRequestSize=1024*1024*100)  //100MB
public class FileUploadServlet extends HttpServlet{
	 private static final long serialVersionUID=205242440643911308L;
	 private static final String UPLOAD_DIR = "uploads";
	 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// gets absolute path of the web application
		String applicationPath=req.getServletContext().getRealPath("");
		 // constructs path of the directory to save uploaded file
		String uploadFilePath=applicationPath+File.separator+UPLOAD_DIR;
		System.out.println(uploadFilePath);
		// creates the save directory if it does not exists
		File fileSaveDir=new File(uploadFilePath);
		if(!fileSaveDir.exists()){
			fileSaveDir.mkdirs();
		}
		System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
		String fileName=null;
		  //Get all the parts from request and write it to the file on server
		for(Part part:req.getParts()){
			fileName=getFileName(part);
			part.write(uploadFilePath + File.separator + fileName);
		}
		req.setAttribute("message", fileName + "File uploaded successfully!");
		getServletContext().getRequestDispatcher("/response.jsp").forward(req, resp);
	}

	private String getFileName(Part part) {
		String contentDisp=part.getHeader("content-disposition");
		System.out.println("content-disposition header= "+contentDisp);
		String[] tokens=contentDisp.split(";");
		for(String token:tokens){
			if(token.trim().startsWith("filename")){
				return token.substring(token.indexOf("=") + 2, token.length()-1);
			}
		}
		return "";
				
	}

}
