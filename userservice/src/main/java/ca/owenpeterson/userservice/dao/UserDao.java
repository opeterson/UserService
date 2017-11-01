package ca.owenpeterson.userservice.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import ca.owenpeterson.userservice.models.UserDto;

@Component
public class UserDao extends HibernateDao 
{
	
	private static final Logger LOGGER = LogManager.getLogger(UserDao.class);
	
	public void saveUser(UserDto userDto) 
	{
		LOGGER.debug("Saving new authenticated user.");
		try {
			super.save(userDto);
		} catch (HibernateException ex)
		{
			LOGGER.debug(ex);
		}
	}
	
	public UserDto getUser(UserDto user)
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
	
	public boolean usernameInUse(UserDto user)
	{
		boolean hasMatch = false;
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserDto.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		criteria.setProjection(Projections.rowCount());
		
		try
		{
			Long count = (Long) criteria.uniqueResult();
			
			if (null != count)
			{
				hasMatch = count >= 1;
			}
		}
		catch (HibernateException h)
		{
			LOGGER.error(h.getMessage());
		}
		catch (Exception e)
		{
			LOGGER.error(e);
		}
		finally
		{
			session.close();
			//sessionFactory.close();
		}
		
				
		return hasMatch;
	}
	 
	public boolean emailInUse(UserDto user)
	{
		boolean hasMatch = false;
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserDto.class);
		criteria.add(Restrictions.eq("email", user.getEmail()));
		
		try
		{
			Long count = (Long) criteria.uniqueResult();
			
			if (null != count)
			{
				hasMatch = count >= 1;
			}
		}
		catch (HibernateException h)
		{
			LOGGER.error(h.getMessage());
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage());
		}
		finally
		{
			session.close();
			//sessionFactory.close();
		}
		
		return hasMatch;
	}
}
