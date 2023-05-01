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
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ciplatform.enums.Role;
import com.ciplatform.enums.Status;

import net.bytebuddy.implementation.bind.annotation.Default;
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(unique=true)
	private String email;
	private String password;
	@Column(unique=true,name = "phone_number")
	private String phoneNumber;
	private String avatar;
	@Column(name = "why_i_volunteer")
	private String whyIVolunteer;
	@Column(name = "employee_id")
	private String employeeId;
	private String department;
	@ManyToOne(targetEntity = City.class)
	@JoinColumn(name = "city_id")
	private City city;
	@ManyToOne(targetEntity = Country.class)
	@JoinColumn(name ="country_id" )
	private Country country;
	@Column(name = "profile_text")
	private String profileText;
	@Column(name = "linked_in_url")
	private String linkedInUrl;
	private String title;
	private Role role;
	private Status status;
	public void setStatus(Status status) {
		this.status = status;
	}
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	@OneToMany(mappedBy ="users",cascade = CascadeType.ALL)
	private List<UserSkill> userSkills;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(int userId, String firstName, String lastName, String email, String password, String phoneNumber,
			String avatar, String whyIVolunteer, String employeeId, String department, City city, Country country,
			String profileText, String linkedInUrl, String title, Role role, Status status, Date createdAt,
			Date updatedAt, Date deletedAt, List<UserSkill> userSkills) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.avatar = avatar;
		this.whyIVolunteer = whyIVolunteer;
		this.employeeId = employeeId;
		this.department = department;
		this.city = city;
		this.country = country;
		this.profileText = profileText;
		this.linkedInUrl = linkedInUrl;
		this.title = title;
		this.role = role;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.userSkills = userSkills;
	}


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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getWhyIVolunteer() {
		return whyIVolunteer;
	}

	public void setWhyIVolunteer(String whyIVolunteer) {
		this.whyIVolunteer = whyIVolunteer;
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

	public String getProfileText() {
		return profileText;
	}

	public void setProfileText(String profileText) {
		this.profileText = profileText;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public List<UserSkill> getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(List<UserSkill> userSkills) {
		this.userSkills = userSkills;
	}

	public Status getStatus() {
		return status;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
}

