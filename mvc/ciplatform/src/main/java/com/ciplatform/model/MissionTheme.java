package com.ciplatform.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mission_theme")
public class MissionTheme {
	@Id
	private int mission_theme_id;
	private String title;
	private int status;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	public MissionTheme() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MissionTheme(int mission_theme_id, String title, int status, Date created_at, Date updated_at,
			Date deleted_at) {
		super();
		this.mission_theme_id = mission_theme_id;
		this.title = title;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public int getMission_theme_id() {
		return mission_theme_id;
	}
	public void setMission_theme_id(int mission_theme_id) {
		this.mission_theme_id = mission_theme_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Date getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}
	@Override
	public String toString() {
		return "mission_theme [mission_theme_id=" + mission_theme_id + ", title=" + title + ", status=" + status
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", deleted_at=" + deleted_at + "]";
	}
	
}
