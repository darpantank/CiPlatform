package project.model;

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
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	
	public UserSkill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSkill(int userSkillId, User users, Skill skill, Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.userSkillId = userSkillId;
		this.users = users;
		this.skill = skill;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
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
