package com.springrest.capstoneproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")

public class User {
	
	private int userId;
	private String userName;
	private String userPass;
	
	
	public User(int userId, String userName, String userPass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
	}
	
	public User() {
		super();
	}

@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
}
