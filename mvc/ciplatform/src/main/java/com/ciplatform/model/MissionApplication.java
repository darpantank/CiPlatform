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

import com.ciplatform.enums.ApprovalStatusMissionApplication;


@Entity
@Table(name = "mission_application")
public class MissionApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mission_application_id")
	private int missionApplicationId;
	@ManyToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "applied_at")
	private Date appliedAt;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="approval_status")
	private ApprovalStatusMissionApplication approvalStatus;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	
	
	
	public MissionApplication() {
		super();
		// TODO Auto-generated constructor stub
	}



	

	

	public MissionApplication(int missionApplicationId, Mission mission, User user, Date appliedAt,
			ApprovalStatusMissionApplication approvalStatus, Date createdAt, Date updatedAt, Date deletedAt) {
		super();
		this.missionApplicationId = missionApplicationId;
		this.mission = mission;
		this.user = user;
		this.appliedAt = appliedAt;
		this.approvalStatus = approvalStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}







	public int getMissionApplicationId() {
		return missionApplicationId;
	}



	public void setMissionApplicationId(int missionApplicationId) {
		this.missionApplicationId = missionApplicationId;
	}



	public Mission getMission() {
		return mission;
	}



	public void setMission(Mission mission) {
		this.mission = mission;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Date getAppliedAt() {
		return appliedAt;
	}



	public void setAppliedAt(Date appliedAt) {
		this.appliedAt = appliedAt;
	}



	



	public ApprovalStatusMissionApplication getApprovalStatus() {
		return approvalStatus;
	}







	public void setApprovalStatus(ApprovalStatusMissionApplication approvalStatus) {
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

	

	
}
