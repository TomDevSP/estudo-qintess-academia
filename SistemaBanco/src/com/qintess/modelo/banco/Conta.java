package com.qintess.modelo.banco;

public abstract class Conta {
	private int agencia;
	private int numConta;
	protected float saldo;
	private float taxaSac = 0.30f;
	private float taxaTransf = 4.0f;
	
	public void depositaCon(float valor) {
		saldo += valor;
	}
	
	public void sacaCon(float valor) {
		if(this.getSaldo() >= valor) {
			this.saldo -= valor + taxaSac;
			System.out.println("Saque realizado na conta");
		} else {
			System.out.println("Não é possível realizar a operação");
		}
	}
	
	public void transfCon(Conta dest, float valor) {
		if(this.getSaldo() >= valor) {
			sacaCon(valor);
			dest.depositaCon(valor);			
		}
	}
	
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public float getTaxaSac() {
		return taxaSac;
	}
	public void setTaxaSac(float taxaSac) {
		this.taxaSac = taxaSac;
	}
	public float getTaxaTransf() {
		return taxaTransf;
	}
	public void setTaxaTransf(float taxaTransf) {
		this.taxaTransf = taxaTransf;
	}

	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", numConta=" + numConta + "]";
	}
	
	
}
