package com.ciplatform.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ciplatform.enums.Availability;
import com.ciplatform.enums.MissionType;
import com.ciplatform.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mission")
public class Mission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mission_id")
	private int missionId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="theme_id")
	private MissionTheme missionTheme;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="city_id")
	private City city ;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="country_id")
	private Country country;
	private String title;
	@Column(name = "short_description")
	private String shortDescription;
	@Column(columnDefinition = "TEXT")
	private String description;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Enumerated(EnumType.STRING)
	@Column(name = "mission_type")
	private MissionType missionType;
	private Status status;
	@Column(name = "organization_name")
	private String organizationName;
	@Column(name = "organization_detail")
	private String organizationDetail;
	private Availability availability;
	@Column(name = "total_seat")
	private long totalSeat;
	@Column(name = "seat_left")
	private long seatLeft;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	private Date deadline;
	@OneToMany(mappedBy = "missions" , cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<MissionSkill> missionSkills;
	@JsonIgnore
	@OneToMany(mappedBy ="mission" , cascade = CascadeType.ALL)
	private List<MissionMedia> missionMedia;
	@JsonIgnore
	@OneToMany(mappedBy ="mission" , cascade = CascadeType.ALL)
	private List<MissionDocument> missionDocument;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "mission")
	private GoalMission goalMission;
	public Mission() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mission(int missionId, MissionTheme missionTheme, City city, Country country, String title,
			String shortDescription, String description, Date startDate, Date endDate, MissionType missionType,
			Status status, String organizationName, String organizationDetail, Availability availability,
			long totalSeat, long seatLeft, Date createdAt, Date updatedAt, Date deletedAt, Date deadline,
			List<MissionSkill> missionSkills, List<MissionMedia> missionMedia, List<MissionDocument> missionDocument,
			GoalMission goalMission) {
		super();
		this.missionId = missionId;
		this.missionTheme = missionTheme;
		this.city = city;
		this.country = country;
		this.title = title;
		this.shortDescription = shortDescription;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.missionType = missionType;
		this.status = status;
		this.organizationName = organizationName;
		this.organizationDetail = organizationDetail;
		this.availability = availability;
		this.totalSeat = totalSeat;
		this.seatLeft = seatLeft;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.deadline = deadline;
		this.missionSkills = missionSkills;
		this.missionMedia = missionMedia;
		this.missionDocument = missionDocument;
		this.goalMission = goalMission;
	}

	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public MissionTheme getMissionTheme() {
		return missionTheme;
	}
	public void setMissionTheme(MissionTheme missionTheme) {
		this.missionTheme = missionTheme;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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
	public Availability getAvailability() {
		return availability;
	}
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	public long getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(long totalSeat) {
		this.totalSeat = totalSeat;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Date getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public List<MissionSkill> getMissionSkills() {
		return missionSkills;
	}
	public void setMissionSkills(List<MissionSkill> missionSkills) {
		this.missionSkills = missionSkills;
	}
	public List<MissionMedia> getMissionMedia() {
		return missionMedia;
	}
	public void setMissionMedia(List<MissionMedia> missionMedia) {
		this.missionMedia = missionMedia;
	}
	public List<MissionDocument> getMissionDocument() {
		return missionDocument;
	}
	public void setMissionDocument(List<MissionDocument> missionDocument) {
		this.missionDocument = missionDocument;
	}
	public GoalMission getGoalMission() {
		return goalMission;
	}
	public void setGoalMission(GoalMission goalMission) {
		this.goalMission = goalMission;
	}

	public long getSeatLeft() {
		return seatLeft;
	}

	public void setSeatLeft(long seatLeft) {
		this.seatLeft = seatLeft;
	}
	
}
	
	