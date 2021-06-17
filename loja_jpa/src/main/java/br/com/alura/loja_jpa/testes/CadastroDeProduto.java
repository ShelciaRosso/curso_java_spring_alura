package br.com.alura.loja_jpa.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja_jpa.dao.CategoriaDAO;
import br.com.alura.loja_jpa.dao.ProdutoDAO;
import br.com.alura.loja_jpa.modelo.Categoria;
import br.com.alura.loja_jpa.modelo.Produto;
import br.com.alura.loja_jpa.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		cadastrarProduto();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		Produto p = produtoDAO.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		//List<Produto> todos = produtoDAO.buscarTodos();
		//List<Produto> todos = produtoDAO.buscarPorNome("Xiaimi Redmi");
		List<Produto> todos = produtoDAO.buscarPorNomeDaCategoria("123");
		todos.forEach(p2 -> System.out.println(p.getNome()));
		
		BigDecimal preco = produtoDAO.buscarPrecoDoProdutoComNome("Xiaimi Redmi");
		System.out.println(preco);
	}

	private static void cadastrarProduto() {
		EntityManager em = JPAUtil.getEntityManager();
		
		Categoria celulares = new Categoria("CELULARES");
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		Produto celular = new Produto("Xiaimi Redmi", "muito legal", new BigDecimal("800"), celulares);
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);
		
		em.flush();
		em.clear();
		
		celular = em.merge(celular);
		celulares = em.merge(celulares);
		celulares.setNome("123");
		em.flush();
		
		//em.remove(celular);
		//em.remove(celulares);
		
		em.getTransaction().commit();
		em.close();
	}

}
