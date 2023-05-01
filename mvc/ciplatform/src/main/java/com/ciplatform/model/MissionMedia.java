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

import com.ciplatform.enums.MediaDefault;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mission_media")
public class MissionMedia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mission_media_id")
	private int missionMediaId;
	@JsonIgnore
	@ManyToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	@Column(name = "media_name")
	private String mediaName;
	@Column(name = "media_type")
	private String mediaType;
	@Column(name = "media_path")
	private String mediaPath;
	@Enumerated(EnumType.ORDINAL)
	private MediaDefault mediaDefault;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	
	
	public MissionMedia() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MissionMedia(int missionMediaId, Mission mission, String mediaName, String mediaType, String mediaPath,
			MediaDefault mediaDefault, Date createdAt, Date updatedAt, Date deletedAt) {
		super();
		this.missionMediaId = missionMediaId;
		this.mission = mission;
		this.mediaName = mediaName;
		this.mediaType = mediaType;
		this.mediaPath = mediaPath;
		this.mediaDefault = mediaDefault;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}


	public int getMissionMediaId() {
		return missionMediaId;
	}


	public void setMissionMediaId(int missionMediaId) {
		this.missionMediaId = missionMediaId;
	}


	public Mission getMission() {
		return mission;
	}


	public void setMission(Mission mission) {
		this.mission = mission;
	}


	public String getMediaName() {
		return mediaName;
	}


	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}


	public String getMediaType() {
		return mediaType;
	}


	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}


	public String getMediaPath() {
		return mediaPath;
	}


	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}


	public MediaDefault getMediaDefault() {
		return mediaDefault;
	}


	public void setMediaDefault(MediaDefault mediaDefault) {
		this.mediaDefault = mediaDefault;
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

