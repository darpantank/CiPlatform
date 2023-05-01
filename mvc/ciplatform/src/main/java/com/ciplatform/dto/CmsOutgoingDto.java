package com.ciplatform.dto;

import com.ciplatform.enums.Status;

public class CmsOutgoingDto {
	private int cmsId;
	private String title;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
