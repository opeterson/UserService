package ca.owenpeterson.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ca.owenpeterson.userservice.controller.UserController;
import ca.owenpeterson.userservice.error.ErrorResponse;

@RestControllerAdvice(assignableTypes = {UserController.class})
public class UserExceptionHandler 
{
	@ExceptionHandler(UsernameExistsException.class)
	public @ResponseBody ResponseEntity<ErrorResponse> handleUsernameExistsException()
	{
		ErrorResponse errorResponse = new ErrorResponse();
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.CONFLICT);
	}
}
