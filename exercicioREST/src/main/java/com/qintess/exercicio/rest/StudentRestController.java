package com.qintess.exercicio.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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

}
