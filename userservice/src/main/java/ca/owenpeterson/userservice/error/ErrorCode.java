package ca.owenpeterson.userservice.error;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement(name="error_code")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
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

	@XmlElement(name="code")
	public String getCode() 
	{
		return code;
	}

	@XmlElement(name="message")
	public String getMessage() 
	{
		return message;
	}
}
