package ca.owenpeterson.userservice.error;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="error_message")
public class ErrorMessage implements Serializable
{
	private static final long serialVersionUID = -1256067502559560230L;
	private ErrorCode errorCode;
	private String developerMessage;
	
	public ErrorMessage(ErrorCode errorCode, String developerMessage)
	{
		this.errorCode = errorCode;
		this.developerMessage = developerMessage;
	}
	
	public ErrorMessage()
	{
		
	}
	
	@XmlElement(name="error_code")
	public ErrorCode getErrorCode() 
	{
		return errorCode;
	}
	
	public void setErrorCode(ErrorCode errorCode) 
	{
		this.errorCode = errorCode;
	}
	
	@XmlElement(name="developer_message")
	public String getDeveloperMessage() 
	{
		return developerMessage;
	}
	
	public void setDeveloperMessage(String errorMessage) 
	{
		this.developerMessage = errorMessage;
	}	
}
