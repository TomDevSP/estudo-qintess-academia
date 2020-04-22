package com.qintess.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:postgresql://localhost:5432/hb_student_tracker";
		String user = "postgres";
		String pass = "1234";	
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
