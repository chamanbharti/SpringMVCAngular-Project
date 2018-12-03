package com.emega.mart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROD_CATEGORIES")
public class Category {
	
	@Id
	@Column(name="CATEGORY_ID")
	private Long categoryId;
	
	@Column(name="CATEGORY")
	private String category;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
