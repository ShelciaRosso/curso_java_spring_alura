import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestaListagem {

public static void main(String[] args) throws SQLException {
		
		//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");

		ConnectionFactory conexao = new ConnectionFactory();
		Connection connection = conexao.recuperaConexao();
	
		Statement stm = connection.createStatement();
		stm.execute("select * from produto");
		
		ResultSet rst = stm.getResultSet();
		
		while (rst.next()) {
			Integer id = rst.getInt("id");
			String nome = rst.getString("nome");
			String descricao = rst.getString("descricao");
			
			System.out.println(id + "|" + nome + "|" + descricao);
		}
		
		connection.close();
	}
}
