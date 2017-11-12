package ca.owenpeterson.userservice.error;

import java.io.Serializable;

public class ErrorMessage implements Serializable
{
	private static final long serialVersionUID = -1256067502559560230L;
	private ErrorCode errorCode;
	private String developerMessage;
	
	public ErrorCode getErrorCode() 
	{
		return errorCode;
	}
	
	public void setErrorCode(ErrorCode errorCode) 
	{
		this.errorCode = errorCode;
	}
	
	public String getDeveloperMessage() 
	{
		return developerMessage;
	}
	
	public void setDeveloperMessage(String errorMessage) 
	{
		this.developerMessage = errorMessage;
	}	
}
