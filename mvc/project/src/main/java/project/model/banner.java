package project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class banner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int banner_id;
	private String image;
	private String text;
	private int sort_order;
	private Date created_at;
	private Date updated_at;
	private Date deleted_at;
	public banner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public banner(int banner_id, String image, String text, int sort_order, Date created_at, Date updated_at,
			Date deleted_at) {
		super();
		this.banner_id = banner_id;
		this.image = image;
		this.text = text;
		this.sort_order = sort_order;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	public int getBanner_id() {
		return banner_id;
	}
	public void setBanner_id(int banner_id) {
		this.banner_id = banner_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
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
