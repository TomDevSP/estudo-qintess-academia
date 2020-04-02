package com.qintess.modelo.banco;

public class ContaPoupanca extends Conta {
	
	@Override
	public void sacaCon(float valor) {
		if(this.getSaldo() > valor) {
			this.saldo -= valor;
		} else {
			System.out.println("Não há saldo disponível para saque");
		}
	}
}
