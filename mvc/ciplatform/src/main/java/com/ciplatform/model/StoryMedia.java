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
@Table(name = "story_media")
public class StoryMedia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "story_media_id")
	private int storyMediaId;
	@JsonIgnore
	@ManyToOne(targetEntity = Story.class)
	@JoinColumn(name = "story_id")
	private Story story;
	private String type;
	private String path;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public StoryMedia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoryMedia(int storyMediaId, Story story, String type, String path, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super();
		this.storyMediaId = storyMediaId;
		this.story = story;
		this.type = type;
		this.path = path;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	public int getStoryMediaId() {
		return storyMediaId;
	}
	public void setStoryMediaId(int storyMediaId) {
		this.storyMediaId = storyMediaId;
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
