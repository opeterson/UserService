package ca.owenpeterson.userservice.exception;

public class UsernameExistsException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5470703382570030320L;
	
	public UsernameExistsException(String message)
	{
		super(message);
	}
}
