package br.com.alura.jdbc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Produto;

public class ProdutoDAO {
	
	private Connection connection;
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Produto produto) throws SQLException {
		String sql = "insert into produto (nome, descricao) values (?, ?)";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			
			pstm.execute();
			
			try (ResultSet rst = pstm.getGeneratedKeys()){
				while (rst.next()) {
					Integer id = rst.getInt(1);
					
					produto.setId(id);
				}
			}
			
		}

	}
	
	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "select id, nome, descricao from produto";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql);){
			pstm.execute();
			
			try (ResultSet rst = pstm.getResultSet()){
				while (rst.next()) {
					produtos.add(new Produto(rst.getInt("id"), rst.getString("nome"), rst.getString("descricao")));
				}
			}
		}
			
		return produtos;
	}

}
