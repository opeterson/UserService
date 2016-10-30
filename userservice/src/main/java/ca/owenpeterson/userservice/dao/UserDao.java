package ca.owenpeterson.userservice.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;

import ca.owenpeterson.userservice.models.UserDto;

@Component
public class UserDao extends HibernateDao {
	
	private static Logger logger = LogManager.getLogger(UserDao.class);
	
	public void save(UserDto userDto) {
		logger.debug("Saving new authenticated user.");
		try {
			super.save(userDto);
		} catch (HibernateException ex)
		{
			logger.debug(ex);
		}
	}
}
