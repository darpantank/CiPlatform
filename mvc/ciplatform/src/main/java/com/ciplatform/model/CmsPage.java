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
import org.hibernate.annotations.Where;

import com.ciplatform.enums.Status;

@Entity
@Table(name="cms_page")
@Where(clause = "deleted_at is null")
public class CmsPage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cms_page_id")
	private int cmsPageId;
	private String title;
	@Column(columnDefinition = "TEXT")
	private String description;
	private String slug;
	private Status status;
	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;
	public CmsPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CmsPage(int cmsPageId, String title, String description, String slug, Status status, Date createdAt,
			Date updatedAt, Date deletedAt) {
		super();
		this.cmsPageId = cmsPageId;
		this.title = title;
		this.description = description;
		this.slug = slug;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	public int getCmsPageId() {
		return cmsPageId;
	}
	public void setCmsPageId(int cmsPageId) {
		this.cmsPageId = cmsPageId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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
	@Override
	public String toString() {
		return "CmsPage [cmsPageId=" + cmsPageId + ", title=" + title + ", description=" + description + ", slug="
				+ slug + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt="
				+ deletedAt + "]";
	}
	
}
