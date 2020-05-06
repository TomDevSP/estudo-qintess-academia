package com.qintess.restful.gerenciadorTom.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.qintess.restful.gerenciadorTom.dtos.ViagemDto;
import com.qintess.restful.gerenciadorTom.responses.Response;
import com.qintess.restful.gerenciadorTom.services.ViagemService;
import com.qintess.restful.gerenciadorTom.entities.Viagem;

@RestController
@RequestMapping("/api/viagens")
public class GerenciadorViagemController {
	
	@Autowired
	private ViagemService viagemService;
	
	@PostMapping(path = "/new")
	public ResponseEntity<Response<Viagem>> cadastrar(@Valid @RequestBody ViagemDto viagemDto, BindResult result){
		Response<Viagem> response = new Response<Viagem>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Viagem viagemSalva = this.viagemService.salvar(viagemDto);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(viagemDto.getId()).toUri();
		
		response.setData(viagemSalva);
		
		return ResponseEntity.created(location).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<Viagem>> listar() {
		List<Viagem> viagens = viagemService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(viagens);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Viagem>> buscar(@PathVariable("id") Long id){
		
		Viagem viagem = viagemService.buscar(id);
		Response<Viagem> response = new Response<Viagem>();
		response.setData(viagem);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
