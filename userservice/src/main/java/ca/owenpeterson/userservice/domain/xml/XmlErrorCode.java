package ca.owenpeterson.userservice.domain.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ca.owenpeterson.userservice.error.ApiErrorCode;

@XmlRootElement(name="error_code")
public class XmlErrorCode implements ApiErrorCode, Serializable
{
	private static final long serialVersionUID = -2188845940692036620L;
	private String code;
	private String message;
	
	public XmlErrorCode()
	{
		
	}
	
	public XmlErrorCode(ApiErrorCode apiErrorCode)
	{
		this.code = apiErrorCode.getCode();
		this.message = apiErrorCode.getMessage();
	}
	
	public XmlErrorCode(String code, String message)
	{
		this.code = code;
		this.message = message;
	}

	@XmlElement(name="code")
	@Override
	public String getCode() 
	{
		return code;
	}

	@XmlElement(name="message")
	@Override
	public String getMessage() 
	{
		return message;
	}
}
