package com.ciplatform.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "country")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private int countryId;
	private String name;
	private String ISO;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Country(int countryId, String name, String iSO, Date createdAt, Date updatedAt, Date deletedAt) {
		super();
		this.countryId = countryId;
		this.name = name;
		ISO = iSO;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getISO() {
		return ISO;
	}
	public void setISO(String iSO) {
		ISO = iSO;
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
	
}
