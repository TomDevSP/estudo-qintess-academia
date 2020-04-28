package com.qintess.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.demo.models.Produto;
import com.qintess.demo.services.ProdutoService;

@Controller
public class IndexController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("")
	public String carregaIndex() {
		
		System.out.println("Carregando o mapeamento index");
		
		Produto produto = new Produto("TV LG 42 polegadas", 859.00);
		Produto produto2 = new Produto("iPhone XR", 5999.34);
		
		produtoService.insere(produto);
		produtoService.insere(produto2);
		
		System.out.println(produtoService.buscaTodos().size());
		System.out.println(produtoService.buscaPorNome("iPhone XR"));
		
		produtoService.buscaTodos();
		
		return "index";
	}

}
