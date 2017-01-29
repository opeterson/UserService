package ca.owenpeterson.userservice.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ca.owenpeterson.userservice.persistence.HibernateUtil;

public class HibernateDao {
	
	public static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public void save(Object obj)
	{
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
		} catch (HibernateException ex)
		{
			throw(ex);
		}
		
		session.close();
	}
	
	public void saveOrUpdate(Object obj)
	{
		//session.saveOrUpdate(obj);
	}
	
	public void delete(Object obj)
	{
		//session.delete(obj);
	}
}
