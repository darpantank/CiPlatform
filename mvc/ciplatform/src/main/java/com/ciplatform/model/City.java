package com.ciplatform.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "city")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int cityId;
	@OneToOne(cascade = CascadeType.ALL)       
	@JoinColumn(name = "country_id")
	private Country country;
	private String name;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City(int cityId, Country country, String name, Date createdAt, Date updatedAt, Date deletedAt) {
		super();
		this.cityId = cityId;
		this.country = country;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}


	public int getCityId() {
		return cityId;
	}


	public void setCityId(int cityId) {
		this.cityId = cityId;
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


	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
