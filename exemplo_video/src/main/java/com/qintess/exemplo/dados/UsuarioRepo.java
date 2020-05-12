package com.qintess.exemplo.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.exemplo.entidades.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{
	

}
