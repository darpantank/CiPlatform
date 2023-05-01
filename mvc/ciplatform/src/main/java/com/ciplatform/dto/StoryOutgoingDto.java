package com.ciplatform.dto;

public class StoryOutgoingDto {
	private int storyId;
	private String storyTitle;
	private String userName;
	private String missionTitle;
	public int getStoryId() {
		return storyId;
	}
	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}
	public String getStoryTitle() {
		return storyTitle;
	}
	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMissionTitle() {
		return missionTitle;
	}
	public void setMissionTitle(String missionTitle) {
		this.missionTitle = missionTitle;
	}
	
}
