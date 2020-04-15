package com.qintess.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.qintess.eventoapp.models.Convidado;
import com.qintess.eventoapp.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
	Iterable<Convidado> findByEvento(Evento evento);
	Convidado findByRg(String rg);
	
}
