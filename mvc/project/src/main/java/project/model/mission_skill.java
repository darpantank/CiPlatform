package project.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class mission_skill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mission_skill_id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_id")
	private skill skills;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="mission_id")
	private mission missions;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	public mission_skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public mission_skill(int mission_skill_id, skill skills, mission missions, Date created_at, Date updated_at,
			Date deleted_at) {
		super();
		this.mission_skill_id = mission_skill_id;
		this.skills = skills;
		this.missions = missions;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	public int getMission_skill_id() {
		return mission_skill_id;
	}
	public void setMission_skill_id(int mission_skill_id) {
		this.mission_skill_id = mission_skill_id;
	}
	public skill getSkills() {
		return skills;
	}
	public void setSkills(skill skills) {
		this.skills = skills;
	}
	
	public mission getMissions() {
		return missions;
	}
	public void setMissions(mission missions) {
		this.missions = missions;
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

	@Override
	public String toString() {
		return "mission_skill [mission_skill_id=" + mission_skill_id + ", skills=" + skills + ", missions=" + missions
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", deleted_at=" + deleted_at + "]";
	}
	
	
	
}
