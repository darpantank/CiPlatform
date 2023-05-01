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
@Table(name = "story_invite")
public class StoryInvite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "story_invite_id")
	private int storyInviteId;
	@ManyToOne(targetEntity = Story.class)
	@JoinColumn(name = "story_id")
	private Story story;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="from_user_id")
	private User fromUser;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="to_user_id")
	private User toUser;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public StoryInvite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoryInvite(int storyInviteId, Story story, User fromUser, User toUser, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super();
		this.storyInviteId = storyInviteId;
		this.story = story;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	public int getStoryInviteId() {
		return storyInviteId;
	}
	public void setStoryInviteId(int storyInviteId) {
		this.storyInviteId = storyInviteId;
	}
	public Story getStory() {
		return story;
	}
	public void setStory(Story story) {
		this.story = story;
	}
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public User getToUser() {
		return toUser;
	}
	public void setToUser(User toUser) {
		this.toUser = toUser;
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
