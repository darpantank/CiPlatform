package project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "contact_us")
public class ContactUs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contact_us_id;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;
	private String subject;
	@Column(columnDefinition = "TEXT")
	private String message;
	@CreationTimestamp
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;
	private Date deleted_at;
	public ContactUs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactUs(int contact_us_id, User user, String subject, String message, Date created_at, Date updated_at,
			Date deleted_at) {
		super();
		this.contact_us_id = contact_us_id;
		this.user = user;
		this.subject = subject;
		this.message = message;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public int getContact_us_id() {
		return contact_us_id;
	}
	public void setContact_us_id(int contact_us_id) {
		this.contact_us_id = contact_us_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	
}
