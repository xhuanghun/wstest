package cn.cjtblog.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory=buildSessionFactory();
	private static SessionFactory buildSessionFactory(){
		System.out.println("buildSessionFactory");
		
		Configuration cfg=new Configuration();
		SessionFactory sfr=cfg.configure().buildSessionFactory(new StandardServiceRegistryBuilder().build());

		return sfr;
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static void closeSessionFactory(){
		if(!sessionFactory.isClosed()){
			sessionFactory.close();
		}
	}
}
