package project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class password_reset {
	@Id
	private String email;
	private String token;
	private Date created_at;
	public password_reset() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public password_reset(String token, String email, Date created_at) {
		super();
		this.email = email;
		this.token = token;
		this.created_at = created_at;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}



	@Override
	public String toString() {
		return "password_reset [token=" + token + ", email=" + email + ", created_at=" + created_at + "]";
	}
	public boolean isValidObject() {
		if(this.email!=""||this.token!="") {
			return true;
		}
		return false;
	}

	
	
}
