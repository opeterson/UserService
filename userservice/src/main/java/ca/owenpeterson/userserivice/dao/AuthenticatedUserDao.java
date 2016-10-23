package ca.owenpeterson.userserivice.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

import ca.owenpeterson.userservice.models.AuthenticatedUser;
import ca.owenpeterson.userservice.persistence.HibernateUtil;

public class AuthenticatedUserDao {
	
	private static Logger logger = LogManager.getLogger(AuthenticatedUserDao.class);
	private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public boolean save(AuthenticatedUser authenticatedUser) {
		return false;
	}
}
