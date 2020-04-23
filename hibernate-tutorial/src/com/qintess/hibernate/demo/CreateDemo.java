package com.qintess.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qintess.hibernate.demo.entity.Instructor;
import com.qintess.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		// criar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		// criar session
		Session session = factory.getCurrentSession();
		
		try {
			// criar objetos
			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
			
			// associar objetos
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			// iniciar transação
			session.beginTransaction();
			
			session.save(tempInstructor);
			
			// commitar transação
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
