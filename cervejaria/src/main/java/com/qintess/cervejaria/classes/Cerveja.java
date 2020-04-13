package com.qintess.cervejaria.classes;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cerveja {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(nullable = false)
	private String sku;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal valor;
	
	@Column(precision = 4, scale = 2, nullable = false)
	private Float teorAlcoolico;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal comissao;
	
	@Column(nullable = false, length = 50)
	private String sabor;
	
	@Column(nullable = false, length = 50)
	private String origem;
	
	@ManyToOne @JoinColumn(name = "codigo_estilo", nullable = false)
	private Estilo codigoEstilo;
	
	@Column(nullable = false)
	private int qtdEstoque;
	
	@Column(nullable = false, length = 100)
	private String foto;
	
	@Column(nullable = false, length = 100)
	private String content_type;
	
	public Cerveja(String sku, String nome, String descricao, BigDecimal valor, Float teorAlcoolico,
			BigDecimal comissao, String sabor, String origem, Estilo codigoEstilo, int qtdEstoque, String foto,
			String content_type) {
		super();
		this.sku = sku;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.teorAlcoolico = teorAlcoolico;
		this.comissao = comissao;
		this.sabor = sabor;
		this.origem = origem;
		this.codigoEstilo = codigoEstilo;
		this.qtdEstoque = qtdEstoque;
		this.foto = foto;
		this.content_type = content_type;
	}
	
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Float getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(Float teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Estilo getCodigoEstilo() {
		return codigoEstilo;
	}

	public void setCodigoEstilo(Estilo codigoEstilo) {
		this.codigoEstilo = codigoEstilo;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getContent_type() {
		return content_type;
	}

	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}
	

}
