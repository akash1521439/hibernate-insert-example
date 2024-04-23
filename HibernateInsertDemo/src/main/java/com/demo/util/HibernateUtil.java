package com.demo.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static StandardServiceRegistry registry;
	private static SessionFactory factory;
	
//	private static SessionFactory sessionFactory = null;
//
//    static {
//        Configuration cfg = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                .applySettings(cfg.getProperties());
//        sessionFactory = cfg.buildSessionFactory(builder.build());
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
	public static SessionFactory getSessionfactory() {
		if(factory == null) {
			try {
				registry = new StandardServiceRegistryBuilder().configure().build();
				MetadataSources sources = new MetadataSources(registry);
				
				Metadata metadata = sources.getMetadataBuilder().build();
				
				factory = metadata.getSessionFactoryBuilder().build();
			}catch(Exception e) {
				e.printStackTrace();
				if(factory != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return factory;
	}
	
	public static void shutDown() {
		if(factory !=null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
