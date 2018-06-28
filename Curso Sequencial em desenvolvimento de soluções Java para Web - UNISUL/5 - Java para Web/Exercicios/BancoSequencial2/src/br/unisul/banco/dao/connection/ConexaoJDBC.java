package br.unisul.banco.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexaoJDBC {


	public static Connection getConnectionDataSource(){
		Connection conn = null;
		try{
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)
			ctx.lookup("java:comp/env/jdbc/SequencialDS");
			conn=ds.getConnection();
			
		}catch(NamingException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return conn;
	}
		
		public static final String driver ="org.postgresql.Driver";
		public static final String url = "jdbc:postgresql://localhost:5432/WSDS";
		public static final String usuario = "postgres";
		public static final String senha = "swordfish55";
		
		public static Connection getConnection(){
			Connection conn =null;
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,usuario,senha);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
		}

	
}
