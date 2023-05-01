package com.ciplatform.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class BannerIncomingDto {
	private int bannerId;
	private String text;
	private int sortOrder;
	private CommonsMultipartFile image;
	public int getBannerId() {
		return bannerId;
	}
	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	public CommonsMultipartFile getImage() {
		return image;
	}
	public void setImage(CommonsMultipartFile image) {
		this.image = image;
	}
	
}
