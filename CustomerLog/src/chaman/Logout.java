package chaman;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		HttpSession session=req.getSession();
		session.invalidate();
		
		//out.println("You are successfully logged out!");
		
		//out.print("<p>You are successfully logged out!</p>");
		//req.setAttribute("logout", "<h1><b>You are successfully logged out!!</b></h1>");
		if(session!=null){
			req.setAttribute("logout", "<h1><b>You are successfully logged out!!</b></h1>");
			req.getRequestDispatcher("login.jsp").include(req, resp);
		}else{
			
			req.getRequestDispatcher("home.jsp").include(req, resp);
		}
		
	}

}
