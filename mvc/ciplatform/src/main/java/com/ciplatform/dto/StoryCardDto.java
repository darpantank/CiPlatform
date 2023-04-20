package com.ciplatform.dto;

public class StoryCardDto {
	private int storyId;
	private StoryMediaTypeUrlDto image;
	private String missionTheme;
	private String storyTitle;
	private String storyDescription;
	private String userAvatar;
	private String userName;
	public int getStoryId() {
		return storyId;
	}
	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}
	public StoryMediaTypeUrlDto getImage() {
		return image;
	}
	public void setImage(StoryMediaTypeUrlDto image) {
		this.image = image;
	}
	public String getMissionTheme() {
		return missionTheme;
	}
	public void setMissionTheme(String missionTheme) {
		this.missionTheme = missionTheme;
	}
	public String getStoryTitle() {
		return storyTitle;
	}
	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}
	public String getStoryDescription() {
		return storyDescription;
	}
	public void setStoryDescription(String storyDescription) {
		this.storyDescription = storyDescription;
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
