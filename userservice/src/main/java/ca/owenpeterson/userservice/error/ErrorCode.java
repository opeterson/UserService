package ca.owenpeterson.userservice.error;

import java.io.Serializable;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import ca.owenpeterson.userservice.domain.xml.ApiErrorCodeXmlAdapter;

@XmlJavaTypeAdapter(ApiErrorCodeXmlAdapter.class)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode implements Serializable, ApiErrorCode
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
