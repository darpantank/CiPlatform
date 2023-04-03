package project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "password_reset")
public class PasswordReset {
	@Id
	private String email;
	private String token;
	private Date created_at;
	public PasswordReset() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public PasswordReset(String token, String email, Date created_at) {
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
