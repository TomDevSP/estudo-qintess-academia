package com.qintess.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	// definir course code padr�o
	public String value() default "QTS";
	
	// definir messagem de erro padr�o
	public String message() default "must start with QTS";
	
	// definir grupo padr�o
	public Class<?>[] groups() default {};
	
	// definir payloads padr�o
	public Class<? extends Payload>[] payload() default {};

}
