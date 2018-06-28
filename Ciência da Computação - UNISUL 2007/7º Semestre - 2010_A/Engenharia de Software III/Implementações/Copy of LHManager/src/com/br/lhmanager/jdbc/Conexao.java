package com.br.lhmanager.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe que faz a conexão com o banco de dados MySql.
 */
public class Conexao {
	
	/**
	 * Retorna uma conexão com o banco de dados.
	 */
	public static Connection getConexao(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/lhmanager", 
					"root", 
					"mysql");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
