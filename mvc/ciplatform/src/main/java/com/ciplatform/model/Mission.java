package com.ciplatform.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.ciplatform.enums.Availability;
import com.ciplatform.enums.MissionType;
import com.ciplatform.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mission")
public class Mission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mission_id;
	@ManyToOne
	@JoinColumn(name="theme_id")
	private MissionTheme mission_theme;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="city_id")
	private City city ;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="country_id")
	private Country country;
	private String title;
	private String short_description;
	private String description;
	private Date start_date;
	private Date end_date;
	@Enumerated(EnumType.STRING)
	private MissionType mission_type;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String organization_name;
	private String organization_detail;
	@Enumerated(EnumType.STRING)
	private Availability availability;
	private long total_seat;
	@CreationTimestamp
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
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
	
	public Mission(int mission_id, MissionTheme mission_theme, City city, Country country, String title,
			String short_description, String description, Date start_date, Date end_date, MissionType mission_type,
			Status status, String organization_name, String organization_detail, Availability availability,
			long total_seat, Date created_at, Date updated_at, Date deleted_at, Date deadline,
			List<MissionSkill> missionSkills, List<MissionMedia> missionMedia, List<MissionDocument> missionDocument,
			GoalMission goalMission) {
		super();
		this.mission_id = mission_id;
		this.mission_theme = mission_theme;
		this.city = city;
		this.country = country;
		this.title = title;
		this.short_description = short_description;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.mission_type = mission_type;
		this.status = status;
		this.organization_name = organization_name;
		this.organization_detail = organization_detail;
		this.availability = availability;
		this.total_seat = total_seat;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.deadline = deadline;
		this.missionSkills = missionSkills;
		this.missionMedia = missionMedia;
		this.missionDocument = missionDocument;
		this.goalMission = goalMission;
	}

	public int getMission_id() {
		return mission_id;
	}
	public void setMission_id(int mission_id) {
		this.mission_id = mission_id;
	}
	public MissionTheme getMission_theme() {
		return mission_theme;
	}
	public void setMission_theme(MissionTheme mission_theme) {
		this.mission_theme = mission_theme;
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
	




	public List<MissionSkill> getMissionSkills() {
		return missionSkills;
	}


	public void setMissionSkills(List<MissionSkill> missionSkills) {
		this.missionSkills = missionSkills;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public MissionType getMission_type() {
		return mission_type;
	}
	public void setMission_type(MissionType mission_type) {
		this.mission_type = mission_type;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getOrganization_name() {
		return organization_name;
	}
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}
	public String getOrganization_detail() {
		return organization_detail;
	}
	public void setOrganization_detail(String organization_detail) {
		this.organization_detail = organization_detail;
	}
	public Availability getAvailability() {
		return availability;
	}
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Date getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}
	public long getTotal_seat() {
		return total_seat;
	}
	public void setTotal_seat(long total_seat) {
		this.total_seat = total_seat;
	}
	
	public GoalMission getGoalMission() {
		return goalMission;
	}
	public void setGoalMission(GoalMission goalMission) {
		this.goalMission = goalMission;
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

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
}
