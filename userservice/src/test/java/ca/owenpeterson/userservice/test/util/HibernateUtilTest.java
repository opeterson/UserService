package ca.owenpeterson.userservice.test.util;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import ca.owenpeterson.userservice.persistence.HibernateUtil;

public class HibernateUtilTest 
{
	
	@Test
	public void testGetSessionFactory()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		assertNotNull("sessionFactory should not be null! Did you create the database? Is it running?", sessionFactory);
	}
	
	@Test
	public void testGetSession()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		assertNotNull("Session should not be null!", session);
	}
}
