package com.ciplatform.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "password_reset")
public class PasswordReset {
	@Id
	private String email;
	private String token;
	@Column(name = "created_at")
	private Date createdAt;
	public PasswordReset() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PasswordReset(String email, String token, Date createdAt) {
		super();
		this.email = email;
		this.token = token;
		this.createdAt = createdAt;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public boolean isValidObject() {
		if(this.email!=""||this.token!="") {
			return true;
		}
		return false;
	}

	
	
}
