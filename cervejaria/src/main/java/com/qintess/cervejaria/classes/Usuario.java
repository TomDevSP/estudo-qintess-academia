package com.qintess.cervejaria.classes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@Column(length = 120, nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private Short ativo;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	public Usuario(String nome, String email, String senha, Short ativo, Date dataNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		setAtivo(ativo);
		this.dataNascimento = dataNascimento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean AtivoValidado(short ativo) {
		
		return(ativo <= (short) 1 && ativo >= 0) ? true : false;
	}

	public void setAtivo(Short ativo) {
		this.ativo = ativo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}
