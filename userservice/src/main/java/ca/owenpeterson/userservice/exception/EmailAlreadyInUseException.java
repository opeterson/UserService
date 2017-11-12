package ca.owenpeterson.userservice.exception;

public class EmailAlreadyInUseException extends Exception 
{
	private static final long serialVersionUID = 410702472382478181L;

	public EmailAlreadyInUseException(String message)
	{
		super(message);
	}
}
