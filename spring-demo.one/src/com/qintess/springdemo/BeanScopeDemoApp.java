package com.qintess.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// carregar arquivo de configura��o do spring
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml"); 
 		
		// recarregar o bean do spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		
		// checar se esses beans s�o os mesmos
		boolean result = (theCoach == alphaCoach);
		
		// imprimir os resultados
		System.out.println("\nMostrando o mesmo objeto: " + result);
		
		System.out.println("\nLoca��o de mem�ria para theCoach: " + theCoach);
		
		System.out.println("\nLoca��o de mem�ria para alphaCoach: " + alphaCoach + "\n");
		
		
		// fechar o context
		context.close();

	}

}
