package com.qintess.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qintess.hibernate.demo.entity.Student;

public class PKStudentDemo {
	
	public static void main(String[] args) {
		
		// criar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
		// criar session
		Session session = factory.getCurrentSession();
				
		try {
			// criar objeto student
			System.out.println("Creating new student object...");
			Student tempStudent1 = new Student("Cinthia", "Anastacia", "cinthia@teste.com");
			Student tempStudent2 = new Student("Rose", "Macedo", "rose@teste.com");
			Student tempStudent3 = new Student("Nino", "Silva", "nino@teste.com");
				
			// iniciar transação
			session.beginTransaction();
					
			// salvar object student
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
					
			// commitar transação
			session.getTransaction().commit();
					
			System.out.println("Done!");
					
		} finally {
			factory.close();
		}

	}

}
