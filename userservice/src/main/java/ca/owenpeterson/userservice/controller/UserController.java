package ca.owenpeterson.userservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.owenpeterson.userservice.dao.UserDao;
import ca.owenpeterson.userservice.models.AuthenticatedUser;
import ca.owenpeterson.userservice.models.UserDto;
import ca.owenpeterson.userservice.util.URIConstants;
import ca.owenpeterson.userservice.validator.UserDtoValidator;

/**
 * This class will be used for CRUD tasks.
 * @author owen
 *
 */
@Controller
public class UserController {
	static Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserDtoValidator userDtoValidator;

	@RequestMapping(value=URIConstants.USER_CREATE, method=RequestMethod.POST)
	public @ResponseBody AuthenticatedUser createUser(@RequestBody UserDto user)
	{
		logger.debug("createUser():begin");
		//TODO: Validate before saving. Does the user already exist? Email in use?
		//TODO: return http status if the user already exists.
		AuthenticatedUser authenticatedUser = new AuthenticatedUser();
		
		if (null != user && !userDtoValidator.isInvalidForCreate(user)) {
			userDao.save(user);
			authenticatedUser.setUsername(user.getUsername());
			authenticatedUser.setEmail(user.getEmail());
		}
		
		logger.debug("createUser():end");
		return authenticatedUser;
	}
}
