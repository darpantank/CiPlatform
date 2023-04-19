package project.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TimeBasedTimesheetIncomingDto {
	private int timesheetId;
	private int missionId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateVolunteered;
	private int hours;
	private int minutes;
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
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "TimeBasedTimesheetIncomingDto [timesheetId=" + timesheetId + ", missionId=" + missionId
				+ ", dateVolunteered=" + dateVolunteered + ", hours=" + hours + ", minutes=" + minutes + ", message="
				+ message + "]";
	}
	
	
}
