package project.model;

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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String first_name;
	private String last_name;
	@Column(unique=true)
	private String email;
	private String password;
	@Column(unique=true)
	private String phone_number;
	private String avatar;
	private String why_i_volunteer;
	private String employee_id;
	private String department;
	@ManyToOne(targetEntity = City.class)
	@JoinColumn(name = "city_id")
	private City city;
	@ManyToOne(targetEntity = Country.class)
	@JoinColumn(name ="country_id" )
	private Country country;
	private String profile_text;
	private String linked_in_url;
	private String title;
	@Enumerated(EnumType.STRING)
	private Status status;
	public void setStatus(Status status) {
		this.status = status;
	}
	@CreationTimestamp
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	@OneToMany(mappedBy ="users",cascade = CascadeType.ALL)
	private List<UserSkill> userSkills;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	public User(int user_id, String first_name, String last_name, String email, String password, String phone_number,
			String avatar, String why_i_volunteer, String employee_id, String department, City city, Country country,
			String profile_text, String linked_in_url, String title, Status status, Date created_at, Date updated_at,
			Date deleted_at, List<UserSkill> userSkills) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.avatar = avatar;
		this.why_i_volunteer = why_i_volunteer;
		this.employee_id = employee_id;
		this.department = department;
		this.city = city;
		this.country = country;
		this.profile_text = profile_text;
		this.linked_in_url = linked_in_url;
		this.title = title;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.userSkills = userSkills;
	}



	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getWhy_i_volunteer() {
		return why_i_volunteer;
	}
	public void setWhy_i_volunteer(String why_i_volunteer) {
		this.why_i_volunteer = why_i_volunteer;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
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
	public String getProfile_text() {
		return profile_text;
	}
	public void setProfile_text(String profile_text) {
		this.profile_text = profile_text;
	}
	public String getLinked_in_url() {
		return linked_in_url;
	}
	public void setLinked_in_url(String linked_in_url) {
		this.linked_in_url = linked_in_url;
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
	
	
	

	
	public List<UserSkill> getUserSkills() {
		return userSkills;
	}



	public void setUserSkills(List<UserSkill> userSkills) {
		this.userSkills = userSkills;
	}



	@Override
	public String toString() {
		return "user [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", password=" + password + ", phone_number=" + phone_number + ", avatar=" + avatar
				+ ", why_i_volunteer=" + why_i_volunteer + ", employee_id=" + employee_id + ", department=" + department
				+ ", city=" + city + ", country=" + country + ", profile_text=" + profile_text + ", linked_in_url="
				+ linked_in_url + ", title=" + title + ", status=" + status + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", deleted_at=" + deleted_at + "]";
	}


	public enum Status{
		ACTIVE,
		INACTIVE;
	}
}

