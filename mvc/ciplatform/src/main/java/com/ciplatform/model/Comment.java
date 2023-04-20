package com.ciplatform.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ciplatform.enums.CommentApprovalStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int comment_id;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	@JsonIgnore
	@ManyToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	private String comment;
	@Enumerated(EnumType.ORDINAL)
	private CommentApprovalStatus approvalStatus;
	@CreationTimestamp
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	
	
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	

	public Comment(int comment_id, User user, Mission mission, String comment, CommentApprovalStatus approvalStatus,
			Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.comment_id = comment_id;
		this.user = user;
		this.mission = mission;
		this.comment = comment;
		this.approvalStatus = approvalStatus;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}






	public int getComment_id() {
		return comment_id;
	}



	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Mission getMission() {
		return mission;
	}



	public void setMission(Mission mission) {
		this.mission = mission;
	}



	public CommentApprovalStatus getApprovalStatus() {
		return approvalStatus;
	}



	public void setApprovalStatus(CommentApprovalStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
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

	

	public String getComment() {
		return comment;
	}






	public void setComment(String comment) {
		this.comment = comment;
	}

}
