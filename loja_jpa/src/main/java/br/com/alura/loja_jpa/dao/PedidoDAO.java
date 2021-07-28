package br.com.alura.loja_jpa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja_jpa.modelo.Pedido;
import br.com.alura.loja_jpa.vo.RelatorioDeVendasVo;

public class PedidoDAO {
	
	private EntityManager em;
	
	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p ";
		
		return em.createQuery(jpql, BigDecimal.class)
				.getSingleResult();
	}
	
	/* Retorno não é o ideal
	 * public List<Object[]> relatorioDeVendas() { String jpql =
	 * "SELECT produto.nome, SUM(item.quantidade), MAX(pedido.data)" +
	 * "FROM Pedido pedido" + "JOIN pedido.itens item" + "JOIN item.produto produto"
	 * + "GROUP BY produto.nome" + "ORDER BY item.quantidade DESC";
	 * 
	 * return em.createQuery(jpql, Object[].class) .getResultList(); }
	 */
	
	public List<RelatorioDeVendasVo> relatorioDeVendas() {
		String jpql = "SELECT new br.com.alura.loja_jpa.vo.RelatorioDeVendasVo(produto.nome, SUM(item.quantidade), MAX(pedido.data)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produto produto "
				+ "GROUP BY produto.nome "
				+ "ORDER BY item.quantidade DESC";
		
		return em.createQuery(jpql, RelatorioDeVendasVo.class)
				.getResultList();
	}
	
	public Pedido buscarPedidoComCliente(Integer id) {
		
		return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE ID = :id", Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	

}
