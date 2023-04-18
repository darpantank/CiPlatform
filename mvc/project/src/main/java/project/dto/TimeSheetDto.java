package project.dto;

import java.time.LocalTime;
import java.util.Date;

public class TimeSheetDto {
	private int timesheetId;
	private int missionId;
	private String missionName;
	private String missionType;
	private Date volunteeredDate;
	private int action;
	private LocalTime time;
	public int getTimesheetId() {
		return timesheetId;
	}
	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public String getMissionName() {
		return missionName;
	}
	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}
	public Date getVolunteeredDate() {
		return volunteeredDate;
	}
	public void setVolunteeredDate(Date volunteeredDate) {
		this.volunteeredDate = volunteeredDate;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getMissionType() {
		return missionType;
	}
	public void setMissionType(String missionType) {
		this.missionType = missionType;
	}
	
	
}
