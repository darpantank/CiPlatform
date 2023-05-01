package com.ciplatform.dto;

import com.ciplatform.enums.ApprovalStatusMissionApplication;

public class MissionApplicationIncomingDto {
	private int missionId;
	private int userId;
	private ApprovalStatusMissionApplication status;
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public ApprovalStatusMissionApplication getStatus() {
		return status;
	}
	public void setStatus(ApprovalStatusMissionApplication status) {
		this.status = status;
	}	
}
