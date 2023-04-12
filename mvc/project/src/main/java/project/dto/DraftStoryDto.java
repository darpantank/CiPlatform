package project.dto;

import java.util.Date;
import java.util.List;

public class DraftStoryDto {
	private int storyId;
	private String storyTitle;
	private Date date;
	private String story;
	private String videoUrl;
	private List<StoryMediaTypeUrlDto> images;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public List<StoryMediaTypeUrlDto> getImages() {
		return images;
	}
	public void setImages(List<StoryMediaTypeUrlDto> images) {
		this.images = images;
	}
	
	
}
