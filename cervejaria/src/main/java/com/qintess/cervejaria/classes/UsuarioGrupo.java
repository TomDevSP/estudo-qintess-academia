package com.qintess.cervejaria.classes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UsuarioGrupo {
	@OneToOne @JoinColumn(name = "codigo_usuario", nullable = false)
	private Usuario usuario;
	
	@OneToOne @JoinColumn(name = "codigo_grupo", nullable = false)
	private Grupo grupo;

	public UsuarioGrupo(Usuario usuario, Grupo grupo) {
		super();
		this.usuario = usuario;
		this.grupo = grupo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
	
}
