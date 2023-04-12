package project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int skill_id;
	private String skill_name;
	private int status;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Skill(int skill_id, String skill_name, int status, Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.skill_id = skill_id;
		this.skill_name = skill_name;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public int getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(int skill_id) {
		this.skill_id = skill_id;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
		return "skill [skill_id=" + skill_id + ", skill_name=" + skill_name + ", status=" + status + ", created_at="
				+ created_at + ", updated_at=" + updated_at + ", deleted_at=" + deleted_at + "]";
	}
	
}
