package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestaRemocao {

public static void main(String[] args) throws SQLException {
		
		ConnectionFactory conexao = new ConnectionFactory();
		Connection connection = conexao.recuperaConexao();
	
		PreparedStatement stm = connection.prepareStatement("delete from produto where id > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Linhas modificadas: " + linhasModificadas);
		
		connection.close();
	}
}
