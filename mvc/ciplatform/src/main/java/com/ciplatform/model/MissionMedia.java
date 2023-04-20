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

import com.ciplatform.enums.MediaDefault;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mission_media")
public class MissionMedia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mission_media_id;
	@JsonIgnore
	@ManyToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	private String media_name;
	private String media_type;
	private String media_path;
	@Enumerated(EnumType.ORDINAL)
	private MediaDefault mediaDefault;
	@CreationTimestamp
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	
	
	public MissionMedia() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	






	public MissionMedia(int mission_media_id, Mission mission, String media_name, String media_type, String media_path,
			MediaDefault mediaDefault, Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.mission_media_id = mission_media_id;
		this.mission = mission;
		this.media_name = media_name;
		this.media_type = media_type;
		this.media_path = media_path;
		this.mediaDefault = mediaDefault;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}











	public int getMission_media_id() {
		return mission_media_id;
	}


	public void setMission_media_id(int mission_media_id) {
		this.mission_media_id = mission_media_id;
	}





	public Mission getMission() {
		return mission;
	}





	public void setMission(Mission mission) {
		this.mission = mission;
	}





	public String getMedia_name() {
		return media_name;
	}


	public void setMedia_name(String media_name) {
		this.media_name = media_name;
	}


	public String getMedia_type() {
		return media_type;
	}


	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}


	public String getMedia_path() {
		return media_path;
	}


	public void setMedia_path(String media_path) {
		this.media_path = media_path;
	}



	public MediaDefault getMediaDefault() {
		return mediaDefault;
	}











	public void setMediaDefault(MediaDefault mediaDefault) {
		this.mediaDefault = mediaDefault;
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
	

	


	@Override
	public String toString() {
		return "MissionMedia [mission_media_id=" + mission_media_id + ", mission=" + mission + ", media_name="
				+ media_name + ", media_type=" + media_type + ", media_path=" + media_path + ", mediaDefault="
				+ mediaDefault + ", created_at=" + created_at + ", updated_at=" + updated_at + ", deleted_at="
				+ deleted_at + "]";
	}
}

