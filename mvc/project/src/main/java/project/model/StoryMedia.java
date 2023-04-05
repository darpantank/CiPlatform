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
@Table(name = "story_media")
public class StoryMedia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int story_media_id;
	@ManyToOne(targetEntity = Story.class)
	@JoinColumn(name = "story_id")
	private Story story;
	private String type;
	private String path;
	@CreationTimestamp
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	public StoryMedia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoryMedia(int story_media_id, Story story, String type, String path, Date created_at, Date updated_at,
			Date deleted_at) {
		super();
		this.story_media_id = story_media_id;
		this.story = story;
		this.type = type;
		this.path = path;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public int getStory_media_id() {
		return story_media_id;
	}
	public void setStory_media_id(int story_media_id) {
		this.story_media_id = story_media_id;
	}
	public Story getStory() {
		return story;
	}
	public void setStory(Story story) {
		this.story = story;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
