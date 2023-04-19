package project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "mission_application")
public class MissionApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mission_application_id;
	@ManyToOne(targetEntity = Mission.class)
	@JoinColumn(name = "mission_id")
	private Mission mission;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	private Date applied_at;
	@Enumerated(EnumType.ORDINAL)
	private ApprovalStatusMissionApplication approval_status;
	@CreationTimestamp
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	
	
	
	public MissionApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public MissionApplication(int mission_application_id, Mission mission, User user, Date applied_at,
			ApprovalStatusMissionApplication approval_status, Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.mission_application_id = mission_application_id;
		this.mission = mission;
		this.user = user;
		this.applied_at = applied_at;
		this.approval_status = approval_status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	

	public int getMission_application_id() {
		return mission_application_id;
	}



	public void setMission_application_id(int mission_application_id) {
		this.mission_application_id = mission_application_id;
	}



	public Mission getMission() {
		return mission;
	}



	public void setMission(Mission mission) {
		this.mission = mission;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Date getApplied_at() {
		return applied_at;
	}



	public void setApplied_at(Date applied_at) {
		this.applied_at = applied_at;
	}



	public ApprovalStatusMissionApplication getApproval_status() {
		return approval_status;
	}



	public void setApproval_status(ApprovalStatusMissionApplication approval_status) {
		this.approval_status = approval_status;
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
		return "MissionApplication [mission_application_id=" + mission_application_id + ", user=" + user + ", applied_at=" + applied_at + ", approval_status=" + approval_status
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", deleted_at=" + deleted_at + "]";
	}



	public enum ApprovalStatusMissionApplication{
		PENDING,
		APPROVE,
		DECLINE
	}
}
