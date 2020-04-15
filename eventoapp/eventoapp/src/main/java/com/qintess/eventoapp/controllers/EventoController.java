package com.qintess.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qintess.eventoapp.models.Evento;
import com.qintess.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository er;
	
	@RequestMapping(value = "/cadastroEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value = "/cadastroEvento", method = RequestMethod.POST)
	public String form(Evento evento) {
		er.save(evento);
		return "redirect:/cadastroEvento";
	}
}
