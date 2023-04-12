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
@Table(name = "story_invite")
public class StoryInvite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int story_invite_id;
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
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	public StoryInvite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StoryInvite(int story_invite_id, Story story, User fromUser, User toUser, Date created_at, Date updated_at,
			Date deleted_at) {
		super();
		this.story_invite_id = story_invite_id;
		this.story = story;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	
	public int getStory_invite_id() {
		return story_invite_id;
	}

	public void setStory_invite_id(int story_invite_id) {
		this.story_invite_id = story_invite_id;
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
