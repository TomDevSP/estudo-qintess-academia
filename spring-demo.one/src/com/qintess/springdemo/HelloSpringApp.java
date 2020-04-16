package com.qintess.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// carregar o arquivo de configuração do spring
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// recuperar bean do spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// chamar métodos dentro do bean
		System.out.println(theCoach.getDailyWorkout());
		
		// chamar novo método fortunes
		System.out.println(theCoach.getDailyFortune());
		
		// close o contexto
		context.close();
	}

}
