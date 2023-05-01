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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mission_document")
public class MissionDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mission_document_id")
	private int missionDocumentId;
	@JsonIgnore
	@ManyToOne(targetEntity = Mission.class)
	@JoinColumn(name="mission_id")
	private Mission mission;
	@Column(name = "document_name")
	private String documentName;
	@Column(name = "document_type")
	private String documentType;
	@Column(name = "document_path")
	private String documentPath;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public MissionDocument() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MissionDocument(int missionDocumentId, Mission mission, String documentName, String documentType,
			String documentPath, Date createdAt, Date updatedAt, Date deletedAt) {
		super();
		this.missionDocumentId = missionDocumentId;
		this.mission = mission;
		this.documentName = documentName;
		this.documentType = documentType;
		this.documentPath = documentPath;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	public int getMissionDocumentId() {
		return missionDocumentId;
	}
	public void setMissionDocumentId(int missionDocumentId) {
		this.missionDocumentId = missionDocumentId;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocumentPath() {
		return documentPath;
	}
	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
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
