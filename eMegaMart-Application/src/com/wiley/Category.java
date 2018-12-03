package com.wiley;

public class Category 
{
	protected int category_id;
	protected String category ;
	
	public void setCategory(String category)
	{
		 this.category = category;
	}
	public String getCategory() 
	{
		return category;
	}
	
	public void setCategory_id(int category_id) 
	{
		this.category_id = category_id;
	}
	public int getCategory_id() 
	{
		return category_id;
	}
}