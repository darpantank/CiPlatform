package com.ciplatform.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GoalBasedTimesheetIncomingDto {
	private int timesheetId;
	private int missionId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateVolunteered;
	private int action;
	private String message;
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
	public Date getDateVolunteered() {
		return dateVolunteered;
	}
	public void setDateVolunteered(Date dateVolunteered) {
		this.dateVolunteered = dateVolunteered;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "GoalBasedTimesheetIncomingDto [timesheetId=" + timesheetId + ", missionId=" + missionId
				+ ", dateVolunteered=" + dateVolunteered + ", action=" + action + ", message=" + message + "]";
	}
	
	
}
