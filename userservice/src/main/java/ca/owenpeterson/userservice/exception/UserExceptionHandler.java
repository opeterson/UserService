package ca.owenpeterson.userservice.exception;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ca.owenpeterson.userservice.controller.UserController;
import ca.owenpeterson.userservice.error.ErrorCode;
import ca.owenpeterson.userservice.error.ErrorMessage;
import ca.owenpeterson.userservice.error.ErrorResponse;

@RestControllerAdvice(assignableTypes = {UserController.class})
public class UserExceptionHandler 
{
	@ExceptionHandler(UsernameExistsException.class)
	public @ResponseBody ResponseEntity<ErrorResponse> handleUsernameExistsException()
	{
		//TODO: Write an ErrorResponse builder;
		ErrorResponse errorResponse = new ErrorResponse();
		ArrayList<ErrorMessage> errorMessages = new ArrayList<ErrorMessage>();
		ErrorMessage usernameExistsMessage = new ErrorMessage(ErrorCode.USERNAME_EXISTS, "User could not be created due to a conflict.");
		errorMessages.add(usernameExistsMessage);
		errorResponse.setErrorMessages(errorMessages);
		HttpStatus status = HttpStatus.CONFLICT;
		errorResponse.setHttpStatus(status);
		return new ResponseEntity<ErrorResponse>(errorResponse, status);
	}
	
	@ExceptionHandler(EmailAlreadyInUseException.class)
	public @ResponseBody ResponseEntity<ErrorResponse> handleEmailAlreadyInUseException()
	{
		//TODO: Write an ErrorResponse builder;
		ErrorResponse errorResponse = new ErrorResponse();
		ArrayList<ErrorMessage> errorMessages = new ArrayList<ErrorMessage>();
		ErrorMessage emailInUseMessage = new ErrorMessage(ErrorCode.EMAIL_IN_USE, "User could not be created due to a conflict.");
		errorMessages.add(emailInUseMessage);
		errorResponse.setErrorMessages(errorMessages);
		HttpStatus status = HttpStatus.CONFLICT;
		errorResponse.setHttpStatus(status);
		return new ResponseEntity<ErrorResponse>(errorResponse, status);
	}
}
