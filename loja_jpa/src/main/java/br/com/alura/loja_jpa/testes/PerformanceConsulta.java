package br.com.alura.loja_jpa.testes;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja_jpa.dao.CategoriaDAO;
import br.com.alura.loja_jpa.dao.ClienteDAO;
import br.com.alura.loja_jpa.dao.PedidoDAO;
import br.com.alura.loja_jpa.dao.ProdutoDAO;
import br.com.alura.loja_jpa.modelo.Categoria;
import br.com.alura.loja_jpa.modelo.Cliente;
import br.com.alura.loja_jpa.modelo.ItemPedido;
import br.com.alura.loja_jpa.modelo.Pedido;
import br.com.alura.loja_jpa.modelo.Produto;
import br.com.alura.loja_jpa.util.JPAUtil;
import br.com.alura.loja_jpa.vo.RelatorioDeVendasVo;

public class PerformanceConsulta {

	public static void main(String[] args) {
		popularBancoDados();
		
		EntityManager em = JPAUtil.getEntityManager();
		Pedido pedido = em.find(Pedido.class, 1l);
		System.out.println(pedido.getCliente().getNome());
		
		em.close();
	}
	
	private static void popularBancoDados() {
		EntityManager em = JPAUtil.getEntityManager();
		
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		Produto celular = new Produto("Xiaimi Redmi", "muito legal", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5", "Playsation 5", new BigDecimal("4500"), videogames);
		Produto macbook = new Produto("Macbook", "Macbook Pro", new BigDecimal("6000"), informatica);
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		Cliente cliente = new Cliente("Rodrigo", "123456789");
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, celular));
		pedido.adicionarItem(new ItemPedido(40, pedido, videogame));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(2, pedido, macbook));
		
		PedidoDAO pedidoDAO = new PedidoDAO(em);

		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(celulares);
		categoriaDAO.cadastrar(videogames);
		categoriaDAO.cadastrar(informatica);
		
		produtoDAO.cadastrar(celular);
		produtoDAO.cadastrar(videogame);
		produtoDAO.cadastrar(macbook);
		
		clienteDAO.cadastrar(cliente);
		
		em.flush();
		
		pedidoDAO.cadastrar(pedido);
		pedidoDAO.cadastrar(pedido2);
		
		em.getTransaction().commit();
		em.close();
	}

}
