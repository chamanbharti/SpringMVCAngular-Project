package com.wiley;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wiley.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductListAction extends Action 
{
	protected ArrayList<Product> getProducts(String inCategoryId )
	{
		Product product = null;
		ArrayList<Product> products = new ArrayList<Product>();
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
			catch(ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(SQLException ae)
			{
			System.out.println("Exception Caught in connection ======"+ae);
			}
		System.out.println("***** befor execute**********"); 
		stmt = conn.createStatement();
		String lQueryString = null;
		if ((inCategoryId != null && inCategoryId.length() > 0 ) )
		{
			lQueryString = "select * from OLNS_PRODUCTS where category_id=" +inCategoryId+ " ";
		}
		else
		{
			lQueryString = "select * from OLNS_PRODUCTS";
		} 
		rs = stmt.executeQuery(lQueryString);
		System.out.println("*****befor next********** lQueryString="+lQueryString);
		while ( rs.next() )
		{
			System.out.println("*********In the while***********");
			product = new Product();
			product.setProduct_id(new Long(rs.getLong("product_id")));  
			product.setCategory_id(new Long(rs.getLong("category_id")));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setPrice(new Double(rs.getDouble("price")));
			products.add(product);
		}
	}
	catch (SQLException e)
	{
		System.err.println(e.getMessage());
	}
	finally
	{
		if (rs != null) 
		{
			try 
			{
				rs.close();
			}
			catch (SQLException sqle) 
			{
				System.err.println(sqle.getMessage());
			}
			rs = null;
		}
		if (stmt != null) {
			try{
				stmt.close();
			}
			catch (SQLException sqle){
				System.err.println(sqle.getMessage());
			}
			stmt = null;
		} 
		if (conn != null) 
		{
			try 
			{
				conn.close();
			}
			catch (SQLException sqle) 
			{
				System.err.println(sqle.getMessage());
			}
			conn = null;
		}
	}
	return products;
}
public ActionForward execute(ActionMapping mapping
						, ActionForm form
						, HttpServletRequest request
						, HttpServletResponse response)
						throws IOException, ServletException 
	{
	// Forward to the appropriate View
	System.out.println("size of ArrayList == i m in ProductListAction");
	String lCategoryId = "";
	String lBrowsCatelog = "";
	lCategoryId = (String)request.getParameter("category_id");
	lBrowsCatelog = (String)request.getParameter("lBrowsCatelog");
	if(lBrowsCatelog == null )
	{
		lBrowsCatelog = "NO";
	}
	System.out.println("lCategoryId  ********** in product list action== "+lCategoryId);
	ArrayList<Product> products=(ArrayList<Product>)getProducts(lCategoryId);
	System.out.println("size of ArrayList == "+products.size());
	if(products.size()>0)
	{
		if ("request".equals(mapping.getScope())) 
		{
		request.setAttribute("products",products);
		request.setAttribute("lBrowsCatelog",lBrowsCatelog);
		}
		else 
		{
		HttpSession session = request.getSession();
		session.setAttribute("products", products);
		session.setAttribute("lBrowsCatelog",lBrowsCatelog);
		}
		String target = "success";
		return (mapping.findForward(target));
	}
	else
		return (mapping.findForward("error"));
	}
}


