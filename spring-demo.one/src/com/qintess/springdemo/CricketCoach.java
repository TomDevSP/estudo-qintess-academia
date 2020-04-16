package com.qintess.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// criar um constructor no-arg
	public CricketCoach() {
		System.out.println("CricketCoach: dentro do constructor no-arg");
	}
	
	
	// o método setter
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: dentro do método setter - setFortuneService");
		this.fortuneService = fortuneService;
	}

	
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
