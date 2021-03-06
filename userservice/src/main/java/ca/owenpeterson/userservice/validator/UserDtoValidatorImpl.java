package ca.owenpeterson.userservice.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.owenpeterson.userservice.dao.UserDao;
import ca.owenpeterson.userservice.models.UserDto;

@Component
public class UserDtoValidatorImpl implements UserDtoValidator {

	@Autowired
	UserDao userDao;
	
	@Override
	public boolean usernameExists(UserDto userDto) 
	{
		if (null == userDto)
		{
			throw new IllegalArgumentException("UserDto cannot be null!");
		}
		
		boolean usernameExists = false;
		
		usernameExists = userDao.usernameInUse(userDto);
		
		return usernameExists;		
	}

	@Override
	public boolean emailInUse(UserDto userDto) 
	{
		if (null == userDto)
		{
			throw new IllegalArgumentException("UserDto cannot be null!");
		}
		
		boolean emailInUse = false;
		
		emailInUse = userDao.emailInUse(userDto);
		
		return emailInUse;	
	}
	
	

}
