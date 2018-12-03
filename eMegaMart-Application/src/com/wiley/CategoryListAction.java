package com.wiley;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;

import com.wiley.Category;

public class CategoryListAction extends Action 
{
	
	
	protected ArrayList<Category> getCategories()
	{
		Category category = null;
		ArrayList<Category> categories=new ArrayList<Category>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			try
			{
				//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			    //conn=DriverManager.getConnection("jdbc:odbc:eMegaMart","","" );	
			    Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","chaman_bharti","@chaman#2012");
			}
			catch(ClassNotFoundException  ae)
			{
				System.out.println("Exception Caught in connection ======"+ae);
			}
			catch(SQLException ae)
			{
				System.out.println("Exception Caught in connection ======"+ae);
			}
			System.out.println("***** befor execute**********");
			
			stmt=conn.createStatement();
			String sql="select * from OLNS_PROD_CATEGORIES";
			rs=stmt.executeQuery(sql);
			System.out.println("SQL:"+sql);
			System.out.println("*****befor next**********");			
			while(rs.next())
			{				
				System.out.println("*******In the While loop******");
				//System.out.println("Cat_ID:"+rs.getInt("category_id"));
				//System.out.println("Cat_Name:"+rs.getString("category"));
				category=new Category();
				category.setCategory_id(new Integer(rs.getInt("category_id")));				
				category.setCategory(rs.getString("category"));			
				categories.add(category);					
			}
			
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
		finally
		{
			if(rs != null)
			{
			try
			{
				rs.close();
			}
			catch(SQLException sqle) 
			{
				System.err.println(sqle.getMessage());
			}
			rs = null;
			}
			if(stmt != null) 
			{
				try
				{
					stmt.close();
				}
				catch(SQLException sqle)
				{
					System.err.println(sqle.getMessage());
				}
				stmt = null;
			} 
			if(conn != null) 
			{
				try 
				{
					conn.close();
				}
				catch(SQLException sqle) 
				{
					System.err.println(sqle.getMessage());
				}
			conn = null;
			}
	}
	return categories;
}

public ActionForward execute(ActionMapping mapping
                             , ActionForm form
                             , HttpServletRequest request
                             , HttpServletResponse response)
                             throws IOException, ServletException 
    {
	// Forward to the appropriate View
	ArrayList<Category> categories=(ArrayList<Category>)getCategories();
	System.out.println("size of ArrayList == "+categories.size());
	//request.setAttribute("categories",categories);
	HttpSession session = request.getSession();
	session.setAttribute("categories",categories);
	String target = "success";
	return (mapping.findForward(target));
	}
}