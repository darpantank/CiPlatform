package project.dto;

import java.util.List;

import project.model.Mission.Availability;

public class UserProfileDto {
	private String firstName;
	private String lastName;
	private String employeeId;
	private String manager;
	private String title;
	private String department;
	private String myProfile;
	private String whyIVolunteer;
	private int cityId;
	private int countryId;
	private Availability availability;
	private String linkedIn;
	private List<Integer> skills;
	private String avatar;
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
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMyProfile() {
		return myProfile;
	}
	public void setMyProfile(String myProfile) {
		this.myProfile = myProfile;
	}
	public String getWhyIVolunteer() {
		return whyIVolunteer;
	}
	public void setWhyIVolunteer(String whyIVolunteer) {
		this.whyIVolunteer = whyIVolunteer;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public Availability getAvailability() {
		return availability;
	}
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public List<Integer> getSkills() {
		return skills;
	}
	public void setSkills(List<Integer> skills) {
		this.skills = skills;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
	
}
