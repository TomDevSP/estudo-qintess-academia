package com.qintess.eventosrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.eventosrest.models.Evento;
import com.qintess.eventosrest.repos.EventoRepos;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Eventos")
@CrossOrigin(origins="*")
public class EventoController {
	
	@Autowired
	EventoRepos eventoRepos;
	
	@GetMapping("/eventos")
	@ApiOperation(value="Retorna Lista de Eventos")
	public List<Evento> listaEventos(){
		return eventoRepos.findAll();
	}
	
	@GetMapping("/evento/{id}")
	@ApiOperation(value="Retorna um evento único")
	public Evento listaEventoUnico(@PathVariable(value="id") int id) {
		return eventoRepos.findById(id);
	}
	
	@PostMapping("/evento")
	@ApiOperation(value="Salva novo evento")
	public Evento salvaEvento(@RequestBody Evento evento) {
		return eventoRepos.save(evento);
	}
	
	@DeleteMapping("/evento")
	@ApiOperation(value="Deleta um evento")
	public void deletaEvento(@RequestBody Evento evento) {
		eventoRepos.delete(evento);
	}
	
	@PutMapping("/evento")
	@ApiOperation(value="Atualiza um evento")
	public Evento updateEvento(@RequestBody Evento evento) {
		return eventoRepos.save(evento);
	}

}
