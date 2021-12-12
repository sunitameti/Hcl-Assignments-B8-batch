package com.xworkz.sunita.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SFUtil {

	private static SessionFactory factory;

	public static SessionFactory getFactory() {
		if (factory != null && factory.isClosed()) {
			throw new IllegalStateException("Someone closed SF");
		}
		return factory;
	}

	static {
		try {
			System.out.println("SF init started");
			Configuration config = new Configuration().configure();
			factory = config.buildSessionFactory();
			System.out.println("SF init completed");
		} catch (HibernateException e) {
			System.out.println("SF error in static block");
			e.printStackTrace();
		}
	}

}
