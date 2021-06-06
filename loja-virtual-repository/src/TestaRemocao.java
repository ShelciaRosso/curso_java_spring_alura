import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestaRemocao {

public static void main(String[] args) throws SQLException {
		
		ConnectionFactory conexao = new ConnectionFactory();
		Connection connection = conexao.recuperaConexao();
	
		Statement stm = connection.createStatement();
		stm.execute("delete from produto where id > 2");
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Linhas modificadas: " + linhasModificadas);
		
		connection.close();
	}
}
