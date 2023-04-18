package project.model;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import project.enums.TimeSheetStatus;

@Entity
@Table(name = "time_sheet")
@Where(clause = "deleted_at IS NULL")
public class TimeSheet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int timesheet_id;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	@JoinColumn(name = "mission_id")
	@ManyToOne(targetEntity = Mission.class)
	private Mission mission;
	private LocalTime time;
	@ColumnDefault("0")
	private int action;
	private Date date_volunteered;
	private String notes;
	@Enumerated(EnumType.ORDINAL)
	private TimeSheetStatus status;
	@CreationTimestamp
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	public TimeSheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TimeSheet(int timesheet_id, User user, Mission mission, LocalTime time, int action, Date date_volunteered,
			String notes, TimeSheetStatus status, Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.timesheet_id = timesheet_id;
		this.user = user;
		this.mission = mission;
		this.time = time;
		this.action = action;
		this.date_volunteered = date_volunteered;
		this.notes = notes;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public int getTimesheet_id() {
		return timesheet_id;
	}
	public void setTimesheet_id(int timesheet_id) {
		this.timesheet_id = timesheet_id;
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
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public Date getDate_volunteered() {
		return date_volunteered;
	}
	public void setDate_volunteered(Date date_volunteered) {
		this.date_volunteered = date_volunteered;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public TimeSheetStatus getStatus() {
		return status;
	}
	public void setStatus(TimeSheetStatus status) {
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
	
}
