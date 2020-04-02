package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fj21", "postgres", "1234");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
