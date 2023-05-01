package com.ciplatform.dto;

import java.util.Date;

public class MissionApplicationOutgoingDto {
	private int missionId;
	private String missionTitle;
	private int userId;
	private String userName;
	private Date appliedDate;
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public String getMissionTitle() {
		return missionTitle;
	}
	public void setMissionTitle(String missionTitle) {
		this.missionTitle = missionTitle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}
	
}
