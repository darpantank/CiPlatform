package com.ciplatform.dto;

import java.util.Date;

import com.ciplatform.enums.MissionType;

public class MissionOutgoingDto {
	private int missionId;
	private String missionTitle;
	private MissionType missionType;
	private Date startDate;
	private Date endDate;
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
	public MissionType getMissionType() {
		return missionType;
	}
	public void setMissionType(MissionType missionType) {
		this.missionType = missionType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
