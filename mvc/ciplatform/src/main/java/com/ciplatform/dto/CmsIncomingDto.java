package com.ciplatform.dto;

import com.ciplatform.enums.Status;

public class CmsIncomingDto {
	private int cmsId;
	private String title;
	private String description;
	private String slug;
	private Status status;
	
	public int getCmsId() {
		return cmsId;
	}
	public void setCmsId(int cmsId) {
		this.cmsId = cmsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CmsIncomingDto [cmsId=" + cmsId + ", title=" + title + ", description=" + description + ", slug=" + slug
				+ ", status=" + status + "]";
	}
	
}
