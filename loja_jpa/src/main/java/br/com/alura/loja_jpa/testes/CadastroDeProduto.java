package br.com.alura.loja_jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja_jpa.dao.ProdutoDAO;
import br.com.alura.loja_jpa.modelo.Categoria;
import br.com.alura.loja_jpa.modelo.Produto;
import br.com.alura.loja_jpa.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		Produto celular = new Produto("Xiaimi Redmi", "muito legal", new BigDecimal("800"), Categoria.CELULARES);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDAO dao = new ProdutoDAO(em);
		
		em.getTransaction().begin();
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}

}
