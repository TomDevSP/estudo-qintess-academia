package com.qintess.cervejaria.classes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class GrupoPermissao {

	@OneToOne @JoinColumn(name = "codigo_grupo", nullable = false)
	private Grupo codigoGrupo;
	
	@OneToOne @JoinColumn(name = "codigo_permissao", nullable = false)
	private Permissao codigoPermissao;

	public GrupoPermissao(Grupo codigoGrupo, Permissao codigoPermissao) {
		super();
		this.codigoGrupo = codigoGrupo;
		this.codigoPermissao = codigoPermissao;
	}

	public Grupo getCodigoGrupo() {
		return codigoGrupo;
	}

	public void setCodigoGrupo(Grupo codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	public Permissao getCodigoPermissao() {
		return codigoPermissao;
	}

	public void setCodigoPermissao(Permissao codigoPermissao) {
		this.codigoPermissao = codigoPermissao;
	}
	
}
