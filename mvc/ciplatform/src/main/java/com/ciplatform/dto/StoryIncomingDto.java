package com.ciplatform.dto;

import com.ciplatform.enums.StoryStatus;

public class StoryIncomingDto {
	private int storyId;
	private StoryStatus status;
	private boolean DeleteStory;
	public int getStoryId() {
		return storyId;
	}
	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}
	public StoryStatus getStatus() {
		return status;
	}
	public void setStatus(StoryStatus status) {
		this.status = status;
	}
	public boolean isDeleteStory() {
		return DeleteStory;
	}
	public void setDeleteStory(boolean deleteStory) {
		DeleteStory = deleteStory;
	}
	

	
	
}
