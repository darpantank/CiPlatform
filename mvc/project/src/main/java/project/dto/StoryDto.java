package project.dto;

import java.util.Arrays;
import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class StoryDto {
	private int missionId;
	private int storyId;
	private String title;
	private Date date;
	private String videoUrl;
	private String story;
	private CommonsMultipartFile[] images;
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	
	public CommonsMultipartFile[] getImages() {
		return images;
	}
	public void setImages(CommonsMultipartFile[] images) {
		this.images = images;
	}
	
	public int getStoryId() {
		return storyId;
	}
	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}
	@Override
	public String toString() {
		return "StoryDto [missionId=" + missionId + ", title=" + title + ", date=" + date + ", videoUrl=" + videoUrl
				+ ", story=" + story + ", images=" + Arrays.toString(images) + "]";
	}
}
