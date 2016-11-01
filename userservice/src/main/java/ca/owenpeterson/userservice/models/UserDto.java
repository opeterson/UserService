package ca.owenpeterson.userservice.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class is used for creating a new User in the database.
 * TODO: Better documentation.
 * @author owen
 *
 */
@Entity
@Table(name="oapuser")
@XmlRootElement(name="user")
public class UserDto implements Serializable {
	
	private static final long serialVersionUID = -4397877745285883766L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	private String username;
	private String password;
	private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
