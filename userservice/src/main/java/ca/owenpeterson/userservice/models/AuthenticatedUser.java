package ca.owenpeterson.userservice.models;

import java.io.Serializable;

public class AuthenticatedUser implements Serializable {

	private static final long serialVersionUID = -6676048350671906151L;
	private String username;
	private String email;
		
	public AuthenticatedUser() {
	}
	
	public AuthenticatedUser(String username, String email) {
		this.username = username;
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
