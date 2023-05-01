package com.ciplatform.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ciplatform.enums.Status;

public class UserProfileEditAdminDto {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String employeeId;
	private String department;
	private String profileText;
	private int countryId;
	private int cityId;
	private Status status;
	private CommonsMultipartFile avatar;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProfileText() {
		return profileText;
	}
	public void setProfileText(String profileText) {
		this.profileText = profileText;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public CommonsMultipartFile getAvatar() {
		return avatar;
	}
	public void setAvatar(CommonsMultipartFile avatar) {
		this.avatar = avatar;
	}
	@Override
	public String toString() {
		return "UserProfileEditAdminDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", employeeId=" + employeeId + ", department="
				+ department + ", profileText=" + profileText + ", countryId=" + countryId + ", cityId=" + cityId
				+ ", status=" + status + ", avatar=" + avatar + "]";
	}
	
}
