package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	/**
	 * Realiza e retorna a conexão com o banco desejado.
	 * @return
	 */
	public static Connection getConexao(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/projeto", 
					"root", 
					"mysql");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
