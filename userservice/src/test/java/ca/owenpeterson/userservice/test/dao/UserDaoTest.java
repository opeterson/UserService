package ca.owenpeterson.userservice.test.dao;

import static org.junit.Assert.fail;

import org.junit.Test;

import ca.owenpeterson.userservice.dao.UserDao;
import ca.owenpeterson.userservice.models.UserDto;

public class UserDaoTest {
	
	UserDao userDao = new UserDao();
	
	@Test
	public void testSave()
	{
		UserDto userDto = new UserDto();
		userDto.setUsername("owenpeterson");
		userDto.setPassword("qwerty123");
		userDto.setEmail("owenpeterson@email.com");
		
		try {
			userDao.saveUser(userDto);
		} catch (Exception ex)
		{
			fail();
		}
	}
}
