package com.qintess.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// carregar o arquivo de configura��o do spring
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// recuperar bean do spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// chamar m�todos dentro do bean
		System.out.println(theCoach.getDailyWorkout());
		
		// chamar novo m�todo fortunes
		System.out.println(theCoach.getDailyFortune());
		
		// close o contexto
		context.close();
	}

}
