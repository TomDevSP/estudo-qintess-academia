package com.qintess.springdemo;

public class MyApp {

	public static void main(String[] args) {
		
		// criar o objeto
		Coach theCoach = new TrackCoach();
		
		// usar o objeto
		System.out.println(theCoach.getDailyWorkout());
	}

}
