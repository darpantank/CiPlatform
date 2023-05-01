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
@Table(name = "mission_invite")
public class MissionInvite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mission_invite_id")
	private int missionInviteId;
	@ManyToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "from_user_id")
	private User fromUser;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "to_user_id")
	private User toUser;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public MissionInvite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMissionInviteId() {
		return missionInviteId;
	}
	public void setMissionInviteId(int missionInviteId) {
		this.missionInviteId = missionInviteId;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public User getToUser() {
		return toUser;
	}
	public void setToUser(User toUser) {
		this.toUser = toUser;
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
