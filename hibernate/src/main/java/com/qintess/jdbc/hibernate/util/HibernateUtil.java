package com.qintess.jdbc.hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.qintess.jdbc.hibernate.entity.Student;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory != null) {
			try {
				Configuration configura = new Configuration();
				
				// Propriedades do hibernate, que substitui o xml
				Properties prop = new Properties();
				prop.put(Environment.DRIVER, "org.postgresql.Driver");
				prop.put(Environment.URL, "jdbc:postgresql://localhost:5432/Student");
				prop.put(Environment.USER, "postgres");
				prop.put(Environment.PASS, "1234");
				
				// Realiza a "tradução" dos termos de acordo com o banco de dados
				prop.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				
				prop.put(Environment.SHOW_SQL, true);
				
				prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				
				prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				configura.setProperties(prop);
				
				configura.addAnnotatedClass(Student.class);
				
				ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configura.getProperties()).build();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
