package com.qintess.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qintess.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		
		// criar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// criar session
		Session session = factory.getCurrentSession();
		
		try {			
			// iniciar transação
			session.beginTransaction();
			
			// buscar students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// mostrar students
			displayStudents(theStudents);
			
			// buscar students: lastName='Silva'
			theStudents = session.createQuery("from Student s where s.lastName='Silva'").getResultList();
			
			// mostrar students last name = Silva
			System.out.println("\n\nStudents who have last name of Silva");
			displayStudents(theStudents);
			
			// commitar transação
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
