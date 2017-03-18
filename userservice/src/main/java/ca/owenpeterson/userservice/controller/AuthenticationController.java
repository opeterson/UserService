package ca.owenpeterson.userservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.owenpeterson.userservice.models.AuthenticatedUser;
import ca.owenpeterson.userservice.models.UserDto;
import ca.owenpeterson.userservice.service.AuthenticationService;
import ca.owenpeterson.userservice.util.URIConstants;

@Controller
public class AuthenticationController {
	static Logger logger = LogManager.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(value=URIConstants.USER_AUTHENTICATE, method=RequestMethod.POST)
	public @ResponseBody AuthenticatedUser authenticateUser(@RequestBody UserDto user)
	{
		//pass userDto to a service that will look for a user with the matching username and password
		return authenticationService.authenticateUser(user);
	}
}
