package ca.owenpeterson.userservice.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
	
	public UserDto authenticate(UserDto user)
	{
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(UserDto.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		criteria.add(Restrictions.eq("password", user.getPassword()));
		
		//TODO: There could be more than one result right now since you aren't validating when creating a new user.
		//The same username and password can be saved twice.
		UserDto foundUser = (UserDto) criteria.uniqueResult();		
		
		session.close();
		return foundUser;
	}
	
	public boolean usernameExists(UserDto user)
	{
		boolean hasMatch = false;
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserDto.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		
		UserDto foundUser = (UserDto) criteria.uniqueResult();		
		
		session.close();
		
		if (null != foundUser)
		{
			hasMatch = user.getUsername().equals(foundUser.getUsername());
		}
		
		return hasMatch;
	}
}
