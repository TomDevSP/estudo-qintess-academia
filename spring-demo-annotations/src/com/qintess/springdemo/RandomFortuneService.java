package com.qintess.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// criar uma array de strings
	private String[] data = {
			"Beware of the wolf in sheep´s clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	// criar um gerador de número aleatório
	private Random myRandom = new Random(); 
	
	@Override
	public String getFortune() {
		// escolher uma string aleatória do array
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];		
		
		return theFortune;
	}

}
