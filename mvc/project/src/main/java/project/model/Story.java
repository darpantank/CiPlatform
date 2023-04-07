package project.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "story")
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int story_id;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	private String title;
	private String description;
	private StoryStatus status;
	private Date published_at;
	@CreationTimestamp
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	@OneToMany(targetEntity = StoryMedia.class ,mappedBy = "story")
	private List<StoryMedia> storyMedia;
	public Story() {
		super();
		// TODO Auto-generated constructor stub
	}

	



	

	public Story(int story_id, User user, Mission mission, String title, String description, StoryStatus status,
			Date published_at, Date created_at, Date updated_at, Date deleted_at, List<StoryMedia> storyMedia) {
		super();
		this.story_id = story_id;
		this.user = user;
		this.mission = mission;
		this.title = title;
		this.description = description;
		this.status = status;
		this.published_at = published_at;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.storyMedia = storyMedia;
	}







	public int getStory_id() {
		return story_id;
	}



	public void setStory_id(int story_id) {
		this.story_id = story_id;
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



	public Date getPublished_at() {
		return published_at;
	}



	public void setPublished_at(Date published_at) {
		this.published_at = published_at;
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

	

	public List<StoryMedia> getStoryMedia() {
		return storyMedia;
	}







	public void setStoryMedia(List<StoryMedia> storyMedia) {
		this.storyMedia = storyMedia;
	}


	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}
	public enum StoryStatus{
		DRAFT,
		PENDING,
		PUBLISHED,
		DECLINED
	}
}
