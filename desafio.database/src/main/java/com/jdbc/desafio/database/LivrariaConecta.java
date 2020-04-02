package com.jdbc.desafio.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LivrariaConecta {
	
	private String url;
	private String usuario;
	private String senha;
	private Connection conn;
	
	public LivrariaConecta() {
		url = "jdbc:postgresql://localhost:5432/livraria";
		usuario = "postgres";
		senha = "1234";
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão estabelecida");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int ExecutaLivraria(String sql) {
		try {
			Statement stm = conn.createStatement();
			int result = stm.executeUpdate(sql);
			conn.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public ResultSet BuscaLivraria(String sql) {
		try {
			Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);
			conn.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
