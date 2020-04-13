package com.qintess.cervejaria.classes;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Cidade {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@ManyToOne @JoinColumn(name = "codigo_estado", nullable = false)
	private Estado estado;

	
	
	public Cidade(String nome, Estado estado) {
		super();
		this.nome = nome;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	

}
