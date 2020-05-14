package com.qintess.eventosrest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket eventoApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.qintess.eventosrest"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
	}
	
	@SuppressWarnings("rawtypes")
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Eventos API REST",
				"API REST de cadastro de eventos.",
				"1.0",
				"Terms of Service",
				new Contact("Wellington Silva", "https://github.com/tomwms89", "wellington.macedo@qintess.com"),
				"Apache License Version 2.0",
				"https://wwww.apache.org/licesen.html", new ArrayList<VendorExtension>()
		);
		
		return apiInfo;		
	}

}
