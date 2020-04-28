package com.qintess.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.demo.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	public Produto findByNome(String nome);

}
