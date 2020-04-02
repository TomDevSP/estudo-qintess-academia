package com.jdbc.estudo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Iniciando execução");
        
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
			Class.forName("org.h2.Driver");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println("Encerrando execução");
    }
}
