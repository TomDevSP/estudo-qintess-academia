package com.qintess.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.demo.models.Produto;
import com.qintess.demo.repos.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void insere(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public Produto buscaPorNome(String nome) {
		return produtoRepository.findByNome(nome);
	}
	
	public List<Produto> buscaTodos(){
		return produtoRepository.findAll();
	}

}
