package com.qintess.restful.gerenciadorTom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qintess.restful.gerenciadorTom.entities.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {
	
	Viagem findByLocalDeDestino(String localDeDestino);

}
