package com.qintess.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.qintess.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// definir bean para o sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	// definir bean para swim coach e injetar dependência
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
