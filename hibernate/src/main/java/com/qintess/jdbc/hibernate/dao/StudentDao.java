package com.qintess.jdbc.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qintess.jdbc.hibernate.entity.Student;
import com.qintess.jdbc.hibernate.util.HibernateUtil;

public class StudentDao {
	public void salvaStudent(Student student) {
		Transaction transacao = null;
		try (Session sessao = HibernateUtil.getSessionFactory().openSession()) {
			
			// começa uma transacao
			transacao = sessao.beginTransaction();
			
			// salva objeto no Student
			sessao.save(student);
			
			// roda transacao
			transacao.commit();
			
		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public List<Student> getStudents(){
		try(Session sessao = HibernateUtil.getSessionFactory().openSession()){
			return sessao.createQuery("from Student", Student.class).list();
		}
	}
}
