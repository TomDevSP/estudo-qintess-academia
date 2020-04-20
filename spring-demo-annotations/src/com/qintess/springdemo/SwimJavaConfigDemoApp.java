package com.qintess.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// ler arquivo de configuração do spring - sem xml
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class); 
		
		// pegar o bean do spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		//Coach alphaCoach = context.getBean("volleyCoach", Coach.class);
		
		// chamar métdo no bean
		System.out.println(theCoach.getDailyWorkout());
		//System.out.println(alphaCoach.getDailyWorkout());
		
		// chamar método para pegar no daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// chamar novos métodos do swim coach com os valores injetados
		System.out.println("email: " + theCoach.getEmail());
		
		System.out.println("team: " + theCoach.getTeam());
		
		// fechar context
		context.close();

	}

}
