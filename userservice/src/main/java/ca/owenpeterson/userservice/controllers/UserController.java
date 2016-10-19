package ca.owenpeterson.userservice.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.owenpeterson.userservice.models.AuthenticatedUser;
import ca.owenpeterson.userservice.models.UserDto;
import ca.owenpeterson.userservice.util.URIConstants;

/**
 * This class will be used for CRUD tasks.
 * @author owen
 *
 */
@Controller
public class UserController {
	static Logger logger = LogManager.getLogger(UserController.class);
	
	//TODO: This is a test.
	@RequestMapping(value=URIConstants.USER_CREATE, method=RequestMethod.POST)
	public @ResponseBody AuthenticatedUser createUser(@RequestBody UserDto user)
	{
		logger.debug("createUser():begin");
		AuthenticatedUser authenticatedUser = new AuthenticatedUser();
		
		if (null != user) {
			authenticatedUser.setUsername(user.getUsername());
			authenticatedUser.setEmail(user.getEmail());
		}
		
		logger.debug("createUser():end");
		return authenticatedUser;
	}
}
