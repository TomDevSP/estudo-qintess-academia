package com.qintess.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// adc novos campos para emailAdress e team
	private String emailAdress;
	private String team;

	
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
	
	
	public String getEmailAdress() {
		return emailAdress;
	}


	public void setEmailAdress(String emailAdress) {
		System.out.println("CricketCoach: dentro do método setter - setEmailAdress");
		this.emailAdress = emailAdress;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		System.out.println("CricketCoach: dentro do método setter - setTeam");
		this.team = team;
	}

}
