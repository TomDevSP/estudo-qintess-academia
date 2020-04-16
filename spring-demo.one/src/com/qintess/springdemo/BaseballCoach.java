package com.qintess.springdemo;

public class BaseballCoach implements Coach {
	
	// definir um campo private para a dependência
	private FortuneService fortuneService;
	
	// definir constructor para injeção de dependência
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		// usar meu fortuneService para pegar o fortune
		return fortuneService.getFortune();
	}
}
