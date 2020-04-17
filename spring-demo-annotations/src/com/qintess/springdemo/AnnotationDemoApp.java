package com.qintess.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// ler arquivo configura spring
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// pegar o bean do spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		//Coach alphaCoach = context.getBean("volleyCoach", Coach.class);
		
		// chamar métdo no bean
		System.out.println(theCoach.getDailyWorkout());
		//System.out.println(alphaCoach.getDailyWorkout());
		
		// chamar método para pegar no daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// fechar context
		context.close();

	}

}
