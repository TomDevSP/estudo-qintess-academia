package com.qintess.modelo.banco;

public class Cliente{
	private String nome;
	private String email;
	private int rg;
	private int cpf;
	
	
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + "]";
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
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	
	
}
