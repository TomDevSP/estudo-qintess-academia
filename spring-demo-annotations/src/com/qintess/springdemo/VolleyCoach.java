package com.qintess.springdemo;

import org.springframework.stereotype.Component;

@Component
public class VolleyCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Pratiquei bloqueio por uma hora";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
