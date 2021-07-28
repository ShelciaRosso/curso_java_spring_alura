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

public class CadastroPedido {

	public static void main(String[] args) {
		popularBancoDados();
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		Produto produto = produtoDAO.buscarPorId(1l);
		Produto produto2 = produtoDAO.buscarPorId(2l);
		Produto produto3 = produtoDAO.buscarPorId(3l);
		
		ClienteDAO clienteDAO = new ClienteDAO(em);
		Cliente cliente = clienteDAO.buscarPorId(1l);

		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		pedido.adicionarItem(new ItemPedido(40, pedido, produto2));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(2, pedido, produto3));
		
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		pedidoDAO.cadastrar(pedido);
		pedidoDAO.cadastrar(pedido2);

		
		em.getTransaction().commit();
		
		BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
		System.out.println("O valor total vendido é de R$" + totalVendido);
		
//		List<Object[]> relatorio = pedidoDAO.relatorioDeVendas();
//		
//		for (Object[] obj : relatorio) {
//			System.out.println((obj[0]));
//			System.out.println((obj[1]));
//			System.out.println((obj[2]));
//		}
		
		List<RelatorioDeVendasVo> relatorio = pedidoDAO.relatorioDeVendas();
		
		relatorio.forEach(System.out::println);
		
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
		
		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(celulares);
		categoriaDAO.cadastrar(videogames);
		categoriaDAO.cadastrar(informatica);
		
		produtoDAO.cadastrar(celular);
		produtoDAO.cadastrar(videogame);
		produtoDAO.cadastrar(macbook);
		
		clienteDAO.cadastrar(cliente);
		
		em.flush();
		em.clear();
		
		celular = em.merge(celular);
		celulares = em.merge(celulares);
		celulares.setNome("123");
		em.flush();
		
		
		
		em.getTransaction().commit();
		em.close();
	}

}
