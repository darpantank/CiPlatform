package com.ciplatform.dto;

public class BannerOutgoingDto {
	private int bannerId;
	private String image;
	private String Text;
	private int sortBy;
	public int getBannerId() {
		return bannerId;
	}
	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public int getSortBy() {
		return sortBy;
	}
	public void setSortBy(int sortBy) {
		this.sortBy = sortBy;
	}
	
}
