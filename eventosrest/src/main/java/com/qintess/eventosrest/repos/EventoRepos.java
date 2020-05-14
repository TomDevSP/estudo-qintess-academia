package com.qintess.eventosrest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.eventosrest.models.Evento;

public interface EventoRepos extends JpaRepository<Evento, Integer> {
	
	Evento findById(int id);

}
