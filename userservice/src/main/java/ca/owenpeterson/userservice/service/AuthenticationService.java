package ca.owenpeterson.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.owenpeterson.userservice.dao.UserDao;
import ca.owenpeterson.userservice.models.AuthenticatedUser;
import ca.owenpeterson.userservice.models.UserDto;

@Service
public class AuthenticationService {
	
	@Autowired
	private UserDao userDao;
	
	public AuthenticatedUser authenticateUser(UserDto user)
	{
		AuthenticatedUser authenticatedUser = new AuthenticatedUser();
		UserDto foundUser = null;
		if (null != user)
		{
			foundUser = userDao.authenticate(user);
		}
		
		if (null != foundUser)
		{
			authenticatedUser.setUsername(foundUser.getUsername());
			authenticatedUser.setEmail(foundUser.getEmail());
		}
		
		return authenticatedUser;
	}
}
