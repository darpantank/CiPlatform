package com.ciplatform.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "goal_mission")
public class GoalMission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int goal_mission_id;
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "mission_id")
	private Mission mission;
	private String goal_objective_text;
	private int goal_value;
	@CreationTimestamp
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	public GoalMission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoalMission(int goal_mission_id, Mission mission, String goal_objective_text, int goal_value,
			Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.goal_mission_id = goal_mission_id;
		this.mission = mission;
		this.goal_objective_text = goal_objective_text;
		this.goal_value = goal_value;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public int getGoal_mission_id() {
		return goal_mission_id;
	}
	public void setGoal_mission_id(int goal_mission_id) {
		this.goal_mission_id = goal_mission_id;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public String getGoal_objective_text() {
		return goal_objective_text;
	}
	public void setGoal_objective_text(String goal_objective_text) {
		this.goal_objective_text = goal_objective_text;
	}
	public int getGoal_value() {
		return goal_value;
	}
	public void setGoal_value(int goal_value) {
		this.goal_value = goal_value;
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
