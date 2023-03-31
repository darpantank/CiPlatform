package project.model;

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
@Table(name = "mission_document")
public class MissionDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mission_document_id;
	@ManyToOne(targetEntity = mission.class)
	@JoinColumn(name="mission_id")
	private mission mission;
	private String document_name;
	private String document_type;
	private String document_path;
	@CreationTimestamp
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	public MissionDocument() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MissionDocument(int mission_document_id, project.model.mission mission, String document_name,
			String document_type, String document_path, Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.mission_document_id = mission_document_id;
		this.mission = mission;
		this.document_name = document_name;
		this.document_type = document_type;
		this.document_path = document_path;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public int getMission_document_id() {
		return mission_document_id;
	}
	public void setMission_document_id(int mission_document_id) {
		this.mission_document_id = mission_document_id;
	}
	public mission getMission() {
		return mission;
	}
	public void setMission(mission mission) {
		this.mission = mission;
	}
	public String getDocument_name() {
		return document_name;
	}
	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}
	public String getDocument_type() {
		return document_type;
	}
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}
	public String getDocument_path() {
		return document_path;
	}
	public void setDocument_path(String document_path) {
		this.document_path = document_path;
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
