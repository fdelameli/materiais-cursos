package br.unisul.banco.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {

/*	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup(
					"java:comp/env/jdbc/SequencialDS");
			
			con = ds.getConnection();

		} catch (NamingException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return con;
	}
*/
	
	
	public static final String DRIVER = "org.postgresql.Driver";
	public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	public static final String USUARIO = "postgres";
	public static final String SENHA = "admin";
	
	// importar de java.sql
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USUARIO, SENHA);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		return con;
	}
	
}
