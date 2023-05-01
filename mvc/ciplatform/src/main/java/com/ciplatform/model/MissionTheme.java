package com.ciplatform.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.ciplatform.enums.Status;

@Entity
@Table(name = "mission_theme")
@Where(clause = "deleted_at is null")
public class MissionTheme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mission_theme_id")
	private int missionThemeId;
	private String title;
	private Status status;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public MissionTheme() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MissionTheme(int missionThemeId, String title, Status status, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super();
		this.missionThemeId = missionThemeId;
		this.title = title;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	public int getMissionThemeId() {
		return missionThemeId;
	}
	public void setMissionThemeId(int missionThemeId) {
		this.missionThemeId = missionThemeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
