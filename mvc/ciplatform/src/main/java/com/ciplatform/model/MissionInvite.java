package com.ciplatform.model;

import java.util.Date;

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
	private int mission_invite_id;
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
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	public MissionInvite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MissionInvite(int mission_invite_id, Mission mission, User fromUser, User toUser, Date created_at,
			Date updated_at, Date deleted_at) {
		super();
		this.mission_invite_id = mission_invite_id;
		this.mission = mission;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public int getMission_invite_id() {
		return mission_invite_id;
	}
	public void setMission_invite_id(int mission_invite_id) {
		this.mission_invite_id = mission_invite_id;
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
	
	
	
	
	
}
