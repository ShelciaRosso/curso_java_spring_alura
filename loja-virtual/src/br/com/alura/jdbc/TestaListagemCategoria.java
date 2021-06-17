package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;


public class TestaListagemCategoria {

public static void main(String[] args) throws SQLException {
		
	try(Connection connection = new ConnectionFactory().recuperaConexao();){
		CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
		List<Categoria> listaCategoria = categoriaDAO.listarComProdutos();
		
		listaCategoria.stream().forEach(ct -> {
			System.out.println(ct.getNome());
		
			for (Produto produto : ct.getProdutos()) {
				System.out.println(ct.getNome() + " - " + produto.getNome());
			}
					
		});
	}
}

}
