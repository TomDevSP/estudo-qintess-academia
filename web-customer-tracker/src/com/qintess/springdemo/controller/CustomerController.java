package com.qintess.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.springdemo.entity.Customer;
import com.qintess.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// injetar o customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	private String listCustomers(Model theModel) {
		
		// pegar customers do service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// adc customers no model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}

}
