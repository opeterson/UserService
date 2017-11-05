package ca.owenpeterson.userservice.models;

import org.springframework.http.HttpStatus;

public abstract class RestEntity 
{
	private String errorMessage;
	private HttpStatus httpStatus;
	
	public String getErrorMessage() 
	{
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) 
	{
		this.errorMessage = errorMessage;
	}
	
	public HttpStatus getHttpStatus() 
	{
		return httpStatus;
	}
	
	public void setHttpStatus(HttpStatus httpStatus) 
	{
		this.httpStatus = httpStatus;
	}	
}
