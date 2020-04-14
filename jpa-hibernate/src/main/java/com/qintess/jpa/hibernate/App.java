package com.qintess.jpa.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		Candidato candidato = new Candidato();
		candidato.setNomeCandidato("Tom");
		
		// Iniciando o JPA manualmente
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev-UP"); // fábrica de instâncias EntityManager
		EntityManager manager = factory.createEntityManager(); // instâncias EntityManager para a aplicação se comunicar com o BD
		
		manager.getTransaction().begin(); // iniciando transação com o banco de dados
		manager.persist(candidato); // persistindo dados
		manager.getTransaction().commit();
		
		System.out.println("ID do candidato: " + candidato.getId());
		System.out.println("Nome Candidato: " + candidato.getNomeCandidato());
		
		manager.close(); // fechando transação com o banco de dados

	}

}
