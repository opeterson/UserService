package ca.owenpeterson.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static Logger logger = LogManager.getLogger(HibernateUtil.class);
	
	static {
		SessionFactory initFactory;
		try {
			if (logger.isDebugEnabled()) logger.debug("HibernateUtil: Starting SessionFactory build.");
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			initFactory = configuration.buildSessionFactory((builder.build()));
			if (logger.isDebugEnabled()) logger.debug("HibernateUtil: SessionFactory built.");
		} catch (Throwable ex) {
			logger.error("HibernateUtil: Could not create SessionFactory! " + ex.getMessage());
			initFactory = null;
		}
		sessionFactory = initFactory;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		sessionFactory.close();
	}

}
