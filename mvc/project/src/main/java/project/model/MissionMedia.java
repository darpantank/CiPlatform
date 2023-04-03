package project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "mission_media")
public class MissionMedia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mission_media_id;
	private int mission_id;
	private String media_name;
	private String media_type;
	private String media_path;
	private MediaDefault MediaDefault;
	@CreationTimestamp
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	
	
	public MissionMedia() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public MissionMedia(int mission_media_id, int mission_id, String media_name, String media_type, String media_path,
			project.model.MissionMedia.MediaDefault mediaDefault, Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.mission_media_id = mission_media_id;
		this.mission_id = mission_id;
		this.media_name = media_name;
		this.media_type = media_type;
		this.media_path = media_path;
		MediaDefault = mediaDefault;
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


	public int getMission_id() {
		return mission_id;
	}


	public void setMission_id(int mission_id) {
		this.mission_id = mission_id;
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
		return MediaDefault;
	}


	public void setMediaDefault(MediaDefault mediaDefault) {
		MediaDefault = mediaDefault;
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


	public enum MediaDefault{
		DEFAULT,
		NOTDEFAULT
	}
}

