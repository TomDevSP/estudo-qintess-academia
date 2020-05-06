package com.qintess.restful.gerenciadorTom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.restful.gerenciadorTom.dtos.ViagemDto;
import com.qintess.restful.gerenciadorTom.entities.Viagem;
import com.qintess.restful.gerenciadorTom.exceptions.ViagemServiceException;
import com.qintess.restful.gerenciadorTom.repositories.ViagemRepository;

@Service
public class ViagemService {

	@Autowired
	private ViagemRepository viagemRepository;

	public List<Viagem> listar() {
		return viagemRepository.findAll();
	}

	public Viagem salvar(ViagemDto viagemDto) {

		Viagem viagem = new Viagem();

		viagem.setLocalDeDestino(viagemDto.getLocalDeDestino());
		viagem.setDataPartida(viagemDto.getDataPartida());
		viagem.setDataRetorno(viagemDto.getDataRetorno());
		viagem.setAcompanhante(viagemDto.getAcompanhante());
		return viagemRepository.save(viagem);
	}

	public Viagem buscar(Long id) {
		Viagem viagem = viagemRepository.findOne(id);

		if (viagem == null) {
			throw new ViagemServiceException("Não existe esta viagem cadastrada");
		}
		return viagem;
	}

}
