package chaman;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
public class HibernateUtil {
	private static final SessionFactory sessionFactory;
		
	static{
			try{
				// Create the SessionFactory from standard (hibernate.cfg.xml)configuration file.
	           
				sessionFactory=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			}
			catch(Throwable ex){
				//log the  exception
				System.err.println("Initial SessionFactory creation failed. "+ex);
				throw new ExceptionInInitializerError(ex);
			}
	  }

	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
