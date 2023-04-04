package project.dto;

import java.util.Date;

public class MissionCommentDto {
	private String name;
	private String comment;
	private String avatar;
	private Date created_at;
	public MissionCommentDto(String name, String comment, String avatar, Date created_at) {
		super();
		this.name = name;
		this.comment = comment;
		this.avatar = avatar;
		this.created_at = created_at;
	}
	public MissionCommentDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
}
