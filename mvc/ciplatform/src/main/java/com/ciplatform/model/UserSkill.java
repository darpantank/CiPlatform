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
@Entity
@Table(name = "user_skill")
public class UserSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_skill_id")
	private  int userSkillId;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User users;
	@ManyToOne(targetEntity = Skill.class)
	@JoinColumn(name = "skill_id")
	private Skill skill;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public UserSkill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSkill(int userSkillId, User users, Skill skill, Date createdAt, Date updatedAt, Date deletedAt) {
		super();
		this.userSkillId = userSkillId;
		this.users = users;
		this.skill = skill;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	public int getUserSkillId() {
		return userSkillId;
	}
	public void setUserSkillId(int userSkillId) {
		this.userSkillId = userSkillId;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
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
