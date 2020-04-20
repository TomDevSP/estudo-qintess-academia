package com.qintess.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	// preciso um método de controle para o formulário inicial
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	// preciso um método de controle para processar o formulário html
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	// novo método de controle para ler dados do formulário e
	// adc dados para o model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// ler parâmetro de requisição para o form html
		String theName = request.getParameter("studentName");
		
		// converte dados para letras maiúsculas
		theName = theName.toUpperCase();
		
		// cria uma messagem
		String result = "Yo! " + theName;
		
		// adc mensagem para o model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		// converte dados para letras maiúsculas
		theName = theName.toUpperCase();
		
		// cria uma messagem
		String result = "Hey My Friend from v3! " + theName;
		
		// adc mensagem para o model
		model.addAttribute("message", result);
		
		return "helloworld";
	}

}
