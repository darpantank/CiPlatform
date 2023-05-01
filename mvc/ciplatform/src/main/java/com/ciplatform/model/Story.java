package com.ciplatform.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.ciplatform.enums.StoryStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "story")
@Where(clause = "deleted_at is null")
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "story_id")
	private int storyId;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne(targetEntity = Mission.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	private String title;
	@Column(length = 4000)
	private String description;
	private StoryStatus status;
	@Column(name = "published_at")
	private Date publishedAt;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	@OneToMany(targetEntity = StoryMedia.class ,mappedBy = "story", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<StoryMedia> storyMedia;
	private long views;
	public Story() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Story(int storyId, User user, Mission mission, String title, String description, StoryStatus status,
			Date publishedAt, Date createdAt, Date updatedAt, Date deletedAt, List<StoryMedia> storyMedia, long views) {
		super();
		this.storyId = storyId;
		this.user = user;
		this.mission = mission;
		this.title = title;
		this.description = description;
		this.status = status;
		this.publishedAt = publishedAt;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.storyMedia = storyMedia;
		this.views = views;
	}
	public int getStoryId() {
		return storyId;
	}
	public void setStoryId(int storyId) {
		this.storyId = storyId;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public StoryStatus getStatus() {
		return status;
	}
	public void setStatus(StoryStatus status) {
		this.status = status;
	}
	public Date getPublishedAt() {
		return publishedAt;
	}
	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
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
	public List<StoryMedia> getStoryMedia() {
		return storyMedia;
	}
	public void setStoryMedia(List<StoryMedia> storyMedia) {
		this.storyMedia = storyMedia;
	}
	public long getViews() {
		return views;
	}
	public void setViews(long views) {
		this.views = views;
	}
	
}
