package com.ciplatform.dto;

import java.util.Date;

public class MissionCommentDto {
	private String name;
	private String comment;
	private String avatar;
	private Date createdAt;
	
	public MissionCommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MissionCommentDto(String name, String comment, String avatar, Date createdAt) {
		super();
		this.name = name;
		this.comment = comment;
		this.avatar = avatar;
		this.createdAt = createdAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
