package br.com.alura.loja_jpa.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja_jpa.modelo.Categoria;

public class CategoriaDAO {
	
	private EntityManager em;
	
	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}

}
