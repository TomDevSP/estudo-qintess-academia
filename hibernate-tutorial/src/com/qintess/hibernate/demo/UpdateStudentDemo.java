package com.qintess.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qintess.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// criar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// criar session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 0;
			
			// acessa e inicia transação
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// recupera student baseado na id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			// alterando dado neste student
			System.out.println("Updating student..");
			myStudent.setEmail("tom@teste.com");
			
			// commitar transação
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
