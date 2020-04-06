package com.qintess.jdbc.hibernate;

import java.util.List;

import com.qintess.jdbc.hibernate.dao.StudentDao;
import com.qintess.jdbc.hibernate.entity.Student;

public class App {
    public static void main( String[] args ) {
        StudentDao studentDao = new StudentDao();
        
        Student student = new Student("Lorde", "Tom", "lordetom89@mail.com");
        
        studentDao.salvaStudent(student);
        
        List < Student > students = studentDao.getStudents();
        students.forEach(s -> System.out.println(s.getFirstName()));
    }
}
