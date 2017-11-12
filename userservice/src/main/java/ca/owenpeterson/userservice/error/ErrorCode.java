package ca.owenpeterson.userservice.error;

import java.io.Serializable;

public enum ErrorCode implements Serializable
{
	USERNAME_EXISTS("", "The specified username already exists."),
	EMAIL_IN_USE("", "The specified email address is already in use.");
	
	private String code;
	private String message;
	
	private ErrorCode(String code, String message)
	{
		this.code = code;
		this.message = message;
	}

	public String getCode() 
	{
		return code;
	}

	public String getMessage() 
	{
		return message;
	}	
}
