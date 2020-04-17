package com.qintess.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// definir um constructor padr�o
	public TennisCoach() {
		System.out.println(">> TennisCoach: dentro do constructor padr�o");
	}
	
	// definir meu m�todo de in�cio
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: dentro do doMyStartupStuff()");
	}
	
	// definir meu m�todo de destrui��o
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: dentro do doMyCleanupStuff()");
	}
	
	/*
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: dentro do m�todo doSomeCrazyStuff()");
		fortuneService = theFortuneService;
	}
	*/
	
	// definir m�todo setter
	/* @Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: dentro do m�todo setFortuneService()");
		fortuneService = theFortuneService;
	}
	*/
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
