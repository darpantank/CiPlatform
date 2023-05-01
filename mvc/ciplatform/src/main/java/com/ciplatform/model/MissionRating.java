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

import com.ciplatform.enums.Rating;
@Entity
@Table(name = "mission_rating")
public class MissionRating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mission_rating_id")
	private int missionRatingId;
	@JoinColumn(name = "user_id")
	@ManyToOne(targetEntity = User.class)
	private User user;
	@JoinColumn(name = "mission_id")
	@ManyToOne(targetEntity = Mission.class)
	private Mission mission;
	@Enumerated(EnumType.ORDINAL)
	private Rating rating;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public MissionRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MissionRating(int missionRatingId, User user, Mission mission, Rating rating, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super();
		this.missionRatingId = missionRatingId;
		this.user = user;
		this.mission = mission;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	public int getMissionRatingId() {
		return missionRatingId;
	}
	public void setMissionRatingId(int missionRatingId) {
		this.missionRatingId = missionRatingId;
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
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
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
