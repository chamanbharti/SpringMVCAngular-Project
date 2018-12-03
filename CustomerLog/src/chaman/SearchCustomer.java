package chaman;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class SearchCustomer extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Connection con = null;
        Statement st;
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","chaman_bharti","@chaman#2012");
            System.out.println("Connected!");
            String fname = request.getParameter("fname");
 
            ArrayList al = null;
            ArrayList pid_list = new ArrayList();
            String query = "select * from family_member where firstname='" + fname + "' ";
            System.out.println("query " + query);
            
            st = con.createStatement();
           
            ResultSet rs = st.executeQuery(query);
 
            while (rs.next()) {
                al = new ArrayList();
 
//                out.println(rs.getString(1));
//                out.println(rs.getString(2));
//                out.println(rs.getString(3));
//                out.println(rs.getString(4));
                al.add(rs.getInt(1));
                al.add(rs.getString(2));
                al.add(rs.getString(3));
                al.add(rs.getLong(4));
                al.add(rs.getLong(5));
 
                System.out.println("al :: " + al);
                pid_list.add(al);
            }
 
            request.setAttribute("piList", pid_list);
            RequestDispatcher view = request.getRequestDispatcher("/searchview.jsp");
            view.forward(request, response);
            con.close();
            System.out.println("Disconnected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}