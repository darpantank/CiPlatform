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
@Table(name = "favorite_mission")
public class FavoriteMission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "favourite_mission_id")
	private int favouriteMissionId;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public FavoriteMission() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FavoriteMission(int favouriteMissionId, User user, Mission mission, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super();
		this.favouriteMissionId = favouriteMissionId;
		this.user = user;
		this.mission = mission;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public FavoriteMission(Mission myMission,User Myuser) {
		this.user = Myuser;
		this.mission = myMission;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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

	public int getFavouriteMissionId() {
		return favouriteMissionId;
	}

	public void setFavouriteMissionId(int favouriteMissionId) {
		this.favouriteMissionId = favouriteMissionId;
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
