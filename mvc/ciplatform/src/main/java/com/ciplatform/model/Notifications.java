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
@Table(name = "notifications")
public class Notifications {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int notificationId;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "is_read")
	private boolean readByUser;
	@Column(name="text")
	private String notificationText;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	
	
	
	public Notifications() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Notifications(int notificationId, User user, boolean readByUser, String notificationText, Date createdAt,
			Date updatedAt, Date deletedAt) {
		super();
		this.notificationId = notificationId;
		this.user = user;
		this.readByUser = readByUser;
		this.notificationText = notificationText;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isReadByUser() {
		return readByUser;
	}
	public void setReadByUser(boolean readByUser) {
		this.readByUser = readByUser;
	}
	public String getNotificationText() {
		return notificationText;
	}
	public void setNotificationText(String notificationText) {
		this.notificationText = notificationText;
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
