package com.qintess.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemonApp {

	public static void main(String[] args) {
		
		// carregar arquivo de configurar spring
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// recuperar bean do spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// checar se s�o iguais
		boolean result = (theCoach == alphaCoach);
		
		// print os resultados
		System.out.println("\nApontando para mesmo objeto: " + result);
		
		System.out.println("\nLoca��o de mem�ria para theCoach: " + theCoach);
		
		System.out.println("\nLoca��o de mem�ria para alphaCoach: " + alphaCoach);
		
		// fechar o context
		context.close();
	}

}
