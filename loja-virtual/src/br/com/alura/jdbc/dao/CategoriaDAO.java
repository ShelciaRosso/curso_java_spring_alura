package br.com.alura.jdbc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class CategoriaDAO {
	
	private Connection connection;
	
	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Categoria categoria) throws SQLException {
		String sql = "insert into categoria (nome) values (?, ?)";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
			pstm.setString(1, categoria.getNome());
			
			pstm.execute();
			
			try (ResultSet rst = pstm.getGeneratedKeys()){
				while (rst.next()) {
					Integer id = rst.getInt(1);
					
					categoria.setId(id);
				}
			}
			
		}

	}
	
	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		String sql = "select id, nome from categoria";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql);){
			pstm.execute();
			
			try (ResultSet rst = pstm.getResultSet()){
				while (rst.next()) {
					categorias.add(new Categoria(rst.getInt("id"), rst.getString("nome")));
				}
			}
		}
			
		return categorias;
	}
	
	public List<Categoria> listarComProdutos() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		Categoria ultima = null;
		
		String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN" + 
					" PRODUTO P ON C.ID = P.CATEGORIA_ID";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql);){
			pstm.execute();
			
			try (ResultSet rst = pstm.getResultSet()){
				while (rst.next()) {
					if(ultima == null || !ultima.getNome().equals(rst.getString(2))) {
						Categoria categoria  = new Categoria(rst.getInt(1), rst.getString(2)); 
						categorias.add(categoria);
						ultima = categoria;
					}
					
					Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
					ultima.adicionar(produto);
				}
			}
		}
			
		return categorias;
	}

}
