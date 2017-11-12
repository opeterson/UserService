package ca.owenpeterson.userservice.error;

import java.io.Serializable;

public enum ErrorCode implements Serializable
{
	USERNAME_EXISTS("1001", "The specified username already exists."),
	EMAIL_IN_USE("1002", "The specified email address is already in use.");
	
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
