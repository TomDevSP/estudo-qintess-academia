package com.qintess.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.springboot.cruddemo.dao.EmployeeDAO;
import com.qintess.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeDAO employeeDAO;
	
	// rápida solução: injetar employee DAO
	@Autowired
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
	// expor "/employees" e retornar lista de employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}
	

}
