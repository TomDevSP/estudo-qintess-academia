package com.qintess.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qintess.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	// definir campo para entitymanager
	private EntityManager entityManager;	
	
	// configurar constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		// obter a sessão atual do hibernate
		Session currentSession = entityManager.unwrap(Session.class);
		
		// criar a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class); 
		
		// executar a query e obter lista de resultados
		List<Employee> employees = theQuery.getResultList();
		
		// retornar os resultados
		return employees;
	}

}
