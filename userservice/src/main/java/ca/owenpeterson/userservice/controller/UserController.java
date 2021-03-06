package ca.owenpeterson.userservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.owenpeterson.userservice.dao.UserDao;
import ca.owenpeterson.userservice.exception.EmailAlreadyInUseException;
import ca.owenpeterson.userservice.exception.UsernameExistsException;
import ca.owenpeterson.userservice.models.AuthenticatedUser;
import ca.owenpeterson.userservice.models.UserDto;
import ca.owenpeterson.userservice.util.URIConstants;
import ca.owenpeterson.userservice.validator.UserDtoValidator;

/**
 * This class will be used for CRUD tasks.
 * @author owen
 *
 */
@RestController
public class UserController {
	static Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserDtoValidator userDtoValidator;

	@RequestMapping(value=URIConstants.USER_CREATE, method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<AuthenticatedUser> createUser(@RequestBody UserDto user) throws UsernameExistsException, EmailAlreadyInUseException
	{
		logger.debug("createUser():begin");
		AuthenticatedUser authenticatedUser = null;
		HttpStatus status = HttpStatus.CREATED;
		
		if (null != user)
		{
			boolean userExists = userDtoValidator.usernameExists(user);
			boolean emailInUse = userDtoValidator.emailInUse(user);
			
			if (!userExists && !emailInUse)
			{				
				userDao.saveUser(user);
				//TODO: Return a userDto or maybe just OK.
				authenticatedUser = new AuthenticatedUser();
				authenticatedUser.setUsername(user.getUsername());
				authenticatedUser.setEmail(user.getEmail());
			}
			else if (userExists)
			{
				logger.debug("Username already exists.");
				throw new UsernameExistsException("The username already exists!");
			}
			else if (emailInUse)
			{
				logger.debug("Email already in use.");
				throw new EmailAlreadyInUseException("The email is already in use!");
			}
		}
		
		logger.debug("createUser():end");
		return new ResponseEntity<AuthenticatedUser>(authenticatedUser, status); 
	}
}
