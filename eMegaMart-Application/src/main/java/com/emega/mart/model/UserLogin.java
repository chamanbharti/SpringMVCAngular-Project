package com.emega.mart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_LOGIN")
public class UserLogin {
	
	@Id
	@GeneratedValue
	@Column(name="USER_NAME")
	
	private Long userId;
	
	@Column(name="USER_PASSWORD")
	private String password;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserId="+this.userId+", Password="+this.password;
	}
}
