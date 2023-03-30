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
@Table(name = "mission_rating")
public class MissionRating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mission_rating_id;
	@JoinColumn(name = "user_id")
	@ManyToOne(targetEntity = user.class)
	private user user;
	@JoinColumn(name = "mission_id")
	@ManyToOne(targetEntity = mission.class)
	private mission mission;
	private Rating rating;
	@CreationTimestamp
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	
	
	
	public MissionRating(int mission_rating_id, project.model.user user, project.model.mission mission, Rating rating,
			Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.mission_rating_id = mission_rating_id;
		this.user = user;
		this.mission = mission;
		this.rating = rating;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}



	public MissionRating() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	public int getMission_rating_id() {
		return mission_rating_id;
	}



	public void setMission_rating_id(int mission_rating_id) {
		this.mission_rating_id = mission_rating_id;
	}



	public user getUser() {
		return user;
	}



	public void setUser(user user) {
		this.user = user;
	}



	public mission getMission() {
		return mission;
	}



	public void setMission(mission mission) {
		this.mission = mission;
	}



	public Rating getRating() {
		return rating;
	}



	public void setRating(Rating rating) {
		this.rating = rating;
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
	public enum Rating{
		ZERO,
		ONE,
		TWO,
		THREE,
		FOUR,
		FIVE
	}
}
