package com.qintess.restspringdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {
	
	// adc c�digo para endpoint "/hello"
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}

}
