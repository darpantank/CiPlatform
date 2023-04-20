package com.ciplatform.dto;

public class FindMissionFromUserDto {
	private int missionId;
	private String missionName;
	private String missionType;
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
	public String getMissionType() {
		return missionType;
	}
	public void setMissionType(String missionType) {
		this.missionType = missionType;
	}
	@Override
	public String toString() {
		return "FindMissionFromUserDto [missionId=" + missionId + ", missionName=" + missionName + ", missionType="
				+ missionType + "]";
	}
	
	
}
