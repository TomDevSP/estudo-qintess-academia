package com.qintess.cervejaria.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import com.qintess.cervejaria.hibernate.HibernateUtil;

public class GenericDAO<Entidade> {
	
	public void salvar(Entidade entidade) {
		try (Session sessao = HibernateUtil.getFabricaSessoes().openSession()) {
			EntityTransaction transacao = sessao.getTransaction();
			transacao.begin();
			sessao.persist(entidade);
			transacao.commit();
		}
	}
	
	public void remover(Entidade entidade) {
		try (Session sessao = HibernateUtil.getFabricaSessoes().openSession()) {
			@SuppressWarnings("unused")
			Object id = HibernateUtil.getPrimaryKey(entidade);
			EntityTransaction transacao = sessao.getTransaction();
			transacao.begin();
			sessao.delete(entidade);
			transacao.commit();
		} 
	}
	
	@SuppressWarnings("unchecked")
	public Entidade atualizar(Entidade entidade) {
		try (Session sessao = HibernateUtil.getFabricaSessoes().openSession()) {
			EntityTransaction transacao = sessao.getTransaction();
			transacao.begin();
			Entidade salvarEntidade = (Entidade) sessao.merge(entidade);
			
			return salvarEntidade;
		} 
	}
	
	public Entidade buscarId(Entidade entidade) {
		try (Session sessao = HibernateUtil.getFabricaSessoes().openSession()) {
			@SuppressWarnings("unused")
			EntityTransaction transacao = sessao.getTransaction();
			Object id = HibernateUtil.getPrimaryKey(entidade);
			@SuppressWarnings("unchecked")
			Entidade generic = (Entidade) sessao.find(entidade.getClass(), id);
			return generic;
		} 		
	}
	
	public List<Entidade> buscarTodos(Class<Entidade> entidade) {
		Session sessao = HibernateUtil.getFabricaSessoes().openSession();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		@SuppressWarnings("unchecked")
		List<Entidade> lista = sessao.createQuery("from " + entidade.getName()).getResultList();
		return lista;
	}
	
	
}
