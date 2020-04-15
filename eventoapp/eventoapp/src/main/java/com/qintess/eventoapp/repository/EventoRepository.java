package com.qintess.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.qintess.eventoapp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String> {
	
	Evento findByCodigo(long codigo);

}
