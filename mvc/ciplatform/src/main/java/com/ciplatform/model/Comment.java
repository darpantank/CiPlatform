package com.ciplatform.model;

import java.util.Date;

import javax.persistence.Column;
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
	@Column(name = "comment_id")
	private int commentId;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	@JsonIgnore
	@ManyToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	private String comment;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "approval_status")
	private CommentApprovalStatus approvalStatus;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	
	
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	

	


	public Comment(int commentId, User user, Mission mission, String comment, CommentApprovalStatus approvalStatus,
			Date createdAt, Date updatedAt, Date deletedAt) {
		super();
		this.commentId = commentId;
		this.user = user;
		this.mission = mission;
		this.comment = comment;
		this.approvalStatus = approvalStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}




	




	public int getCommentId() {
		return commentId;
	}









	public void setCommentId(int commentId) {
		this.commentId = commentId;
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









	public String getComment() {
		return comment;
	}






	public void setComment(String comment) {
		this.comment = comment;
	}

}
