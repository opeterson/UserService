package ca.owenpeterson.userservice.error;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;

@XmlRootElement(name="error_response")
public class ErrorResponse implements Serializable
{
	private static final long serialVersionUID = 7748421342307091183L;
	private HttpStatus httpStatus;
	private List<ErrorMessage> errorMessages;	
	
	public List<ErrorMessage> getErrorMessages() 
	{
		return errorMessages;
	}
	
	public HttpStatus getHttpStatus() 
	{
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) 
	{
		this.httpStatus = httpStatus;
	}
	
	public void setErrorMessages(List<ErrorMessage> errorMessages) 
	{
		this.errorMessages = errorMessages;
	}	
}
