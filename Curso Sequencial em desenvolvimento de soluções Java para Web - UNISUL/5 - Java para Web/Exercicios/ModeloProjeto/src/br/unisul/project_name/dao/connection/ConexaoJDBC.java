package br.unisul.project_name.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {

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
