package com.qintess.springdemo;

public class FootballCoach implements Coach {
	
	@Override
	public String getDailyWorkout() {
		return "Passou 30 minutos treinando lançamento!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}
}
