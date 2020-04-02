package com.qintess.modelo.banco;

public class ContaPoupanca extends Conta {
	
	@Override
	public void sacaCon(float valor) {
		if(this.getSaldo() > valor) {
			this.saldo -= valor;
		} else {
			System.out.println("N�o h� saldo dispon�vel para saque");
		}
	}
}
