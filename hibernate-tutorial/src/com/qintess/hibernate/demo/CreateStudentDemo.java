package com.qintess.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qintess.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// criar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// criar session
		Session session = factory.getCurrentSession();
		
		try {
			// criar objeto student
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Tom", "Silva", "tom.silva@teste.com");
			
			// iniciar transação
			session.beginTransaction();
			
			// salvar object student
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			// commitar transação
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
