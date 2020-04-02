package com.qintess.modelo.banco;

public class ContaCorrente extends Conta {
	private float valorLim = 300.0f;
	private float taxaLim = 2.0f;
	
	@Override
	public void sacaCon(float valor) {
		if(this.getSaldo() >= valor) {
			if(this.getSaldo() <= valorLim) {
				this.saldo -= valor + taxaLim;
			}
		} else {
			System.out.println("Não há saldo disponível para saque");
		}
			
	}
	
	
	public float getValorLim() {
		return valorLim;
	}
	public void setValorLim(float valorLim) {
		this.valorLim = valorLim;
	}
	public float getTaxaLim() {
		return taxaLim;
	}
	public void setTaxaLim(float taxaLim) {
		this.taxaLim = taxaLim;
	}
	
	
}
