package br.com.alura.loja_jpa.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja_jpa.modelo.Produto;

public class ProdutoDAO {
	
	private EntityManager em;
	
	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

}
