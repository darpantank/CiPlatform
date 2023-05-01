package com.ciplatform.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "mission_skill")
public class MissionSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mission_skill_id")
	private int missionSkillId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_id")
	private Skill skills;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="mission_id")
	private Mission missions;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public MissionSkill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MissionSkill(int missionSkillId, Skill skills, Mission missions, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super();
		this.missionSkillId = missionSkillId;
		this.skills = skills;
		this.missions = missions;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	public int getMissionSkillId() {
		return missionSkillId;
	}
	public void setMissionSkillId(int missionSkillId) {
		this.missionSkillId = missionSkillId;
	}
	public Skill getSkills() {
		return skills;
	}
	public void setSkills(Skill skills) {
		this.skills = skills;
	}
	public Mission getMissions() {
		return missions;
	}
	public void setMissions(Mission missions) {
		this.missions = missions;
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
