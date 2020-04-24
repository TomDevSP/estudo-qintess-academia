package com.qintess.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qintess.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// pegar a session atual do hibernate
		Session currentSession = sessionFactory.getCurrentSession();
		
		// criar uma query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		// executar query e pegar result list
		List<Customer> customers = theQuery.getResultList();
		
		// retornar os results
		return customers;
	}

}
