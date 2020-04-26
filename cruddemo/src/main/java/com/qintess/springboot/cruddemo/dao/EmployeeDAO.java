package com.qintess.springboot.cruddemo.dao;

import java.util.List;

import com.qintess.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();

}
