package com.ciplatform.dto;

import java.sql.Date;
import java.util.Arrays;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ciplatform.enums.Availability;
import com.ciplatform.enums.MissionType;
import com.ciplatform.enums.Status;

public class MissionIncomingDto {
	private int missionId;
	private String title;
	private String shortDescription;
	private String	description;
	private int countryId;
	private int cityId;
	private Status status;
	private String organizationName;
	private String organizationDetail;
	private Date startDate;
	private Date endDate;
	private MissionType missionType;
	private int totalSeat;
	private Date deadline;
	private int themeId;
	private int[] skillsId;
	private CommonsMultipartFile[] missionDocuments;
	private Availability availability;
	private CommonsMultipartFile[] missionImages;
	private String goalObjectiveText;
	private int goalValue;
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationDetail() {
		return organizationDetail;
	}
	public void setOrganizationDetail(String organizationDetail) {
		this.organizationDetail = organizationDetail;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public MissionType getMissionType() {
		return missionType;
	}
	public void setMissionType(MissionType missionType) {
		this.missionType = missionType;
	}
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public int getThemeId() {
		return themeId;
	}
	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}
	public int[] getSkillsId() {
		return skillsId;
	}
	public void setSkillsId(int[] skillsId) {
		this.skillsId = skillsId;
	}
	public CommonsMultipartFile[] getMissionDocuments() {
		return missionDocuments;
	}
	public void setMissionDocuments(CommonsMultipartFile[] missionDocuments) {
		this.missionDocuments = missionDocuments;
	}
	public Availability getAvailability() {
		return availability;
	}
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	public CommonsMultipartFile[] getMissionImages() {
		return missionImages;
	}
	public void setMissionImages(CommonsMultipartFile[] missionImages) {
		this.missionImages = missionImages;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getGoalObjectiveText() {
		return goalObjectiveText;
	}
	public void setGoalObjectiveText(String goalObjectiveText) {
		this.goalObjectiveText = goalObjectiveText;
	}
	public int getGoalValue() {
		return goalValue;
	}
	public void setGoalValue(int goalValue) {
		this.goalValue = goalValue;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "MissionIncomingDto [missionId=" + missionId + ", shortDescription=" + shortDescription
				+ ", description=" + description + ", countryId=" + countryId + ", cityId=" + cityId + ", status="
				+ status + ", organizationName=" + organizationName + ", organizationDetail=" + organizationDetail
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", missionType=" + missionType + ", totalSeat="
				+ totalSeat + ", deadline=" + deadline + ", themeId=" + themeId + ", skillsId="
				+ Arrays.toString(skillsId) + ", missionDocuments=" + Arrays.toString(missionDocuments)
				+ ", availability=" + availability + ", missionImages=" + Arrays.toString(missionImages)
				+ ", goalObjectiveText=" + goalObjectiveText + ", goalValue=" + goalValue + "]";
	}
	
	
	
	
	
	
	
}
