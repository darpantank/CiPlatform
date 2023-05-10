package com.ciplatform.dto;

import com.ciplatform.enums.NotificationType;

public class NotificationSetDto {
	private int userId;
	private String notificationText;
	private NotificationType type;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNotificationText() {
		return notificationText;
	}
	public void setNotificationText(String notificationText) {
		this.notificationText = notificationText;
	}
	public NotificationType getType() {
		return type;
	}
	public void setType(NotificationType type) {
		this.type = type;
	}
	
	
}
