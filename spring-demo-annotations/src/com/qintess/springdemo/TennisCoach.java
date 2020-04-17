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
	
	// definir um constructor padrão
	public TennisCoach() {
		System.out.println(">> TennisCoach: dentro do constructor padrão");
	}
	
	// definir meu método de início
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: dentro do doMyStartupStuff()");
	}
	
	// definir meu método de destruição
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: dentro do doMyCleanupStuff()");
	}
	
	/*
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: dentro do método doSomeCrazyStuff()");
		fortuneService = theFortuneService;
	}
	*/
	
	// definir método setter
	/* @Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: dentro do método setFortuneService()");
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
