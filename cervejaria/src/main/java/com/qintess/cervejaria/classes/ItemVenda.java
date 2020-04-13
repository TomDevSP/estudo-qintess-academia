package com.qintess.cervejaria.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class ItemVenda {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(length = 11, nullable = false)
	private int quantidade;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private Float valorUnitario;
	
	@ManyToMany @JoinColumn(name = "codigo_cerveja", nullable = false)
	private Cerveja cerveja;
	
	@OneToOne @JoinColumn(name = "codigo_venda", nullable = false)
	private Venda venda;

	public ItemVenda(int quantidade, Float valorUnitario, Cerveja cerveja, Venda venda) {
		super();
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.cerveja = cerveja;
		this.venda = venda;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Cerveja getCerveja() {
		return cerveja;
	}

	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
}
