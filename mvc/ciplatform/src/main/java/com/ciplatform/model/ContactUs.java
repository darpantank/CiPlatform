package com.ciplatform.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "contact_us")
public class ContactUs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_us_id")
	private int contactUsId;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	private String subject;
	@Column(columnDefinition = "TEXT")
	private String message;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public ContactUs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ContactUs(int contactUsId, User user, String subject, String message, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super();
		this.contactUsId = contactUsId;
		this.user = user;
		this.subject = subject;
		this.message = message;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	
	public int getContactUsId() {
		return contactUsId;
	}

	public void setContactUsId(int contactUsId) {
		this.contactUsId = contactUsId;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	
}
