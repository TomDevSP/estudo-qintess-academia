package com.qintess.exercicio.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.exercicio.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	// definir @PostConstruct para carregar dados do student, apenas uma vez
	
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Tom", "Silva"));
		theStudents.add(new Student("Cin", "Anastacia"));
		theStudents.add(new Student("Nino", "Macedo"));
		
	}
	
	// definir endpoint para "/students" - retorna lista dos students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	// definir endpoint para "/students/{studentId}" - retorna student indexado
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// apenas indexar da lista
		
		// checar o studentId contra o tamanho da lista
		
		if (studentId >= theStudents.size() || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
	
		return theStudents.get(studentId);		
	}
	
	// adc um controlador de exceção usando @ExceptionHandler
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		// criar um StudentErrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// retorna ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// adc outro controlador de exceção, para capturar qualquer exceção
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		// criar um StudentErrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
				
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
				
		// retorna ResponseEntity
				
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
