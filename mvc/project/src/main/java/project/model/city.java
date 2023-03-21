package project.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class city {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int city_id;
	@OneToOne(cascade = CascadeType.ALL)       
	@JoinColumn(name = "country_id")
	private country country;
	private String name;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	public city() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public city(int city_id, project.model.country country, String name, Date created_at, Date updated_at,
			Date deleted_at) {
		super();
		this.city_id = city_id;
		this.country = country;
		this.name = name;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}

	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	
	public country getCountry() {
		return country;
	}

	public void setCountry(country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "city [city_id=" + city_id + ", country=" + country + ", name=" + name + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", deleted_at=" + deleted_at + "]";
	}	
	
}
