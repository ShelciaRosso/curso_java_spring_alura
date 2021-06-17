package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		
		Produto comada = new Produto("C�moda", "C�moda vertical");
		
		try(Connection connection = new ConnectionFactory().recuperaConexao();){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(comada);
			
			List<Produto> listaProdutos = produtoDAO.listar();
			
			listaProdutos.stream().forEach(lp -> System.out.println(lp));
		}

	}

}
