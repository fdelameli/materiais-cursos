package br.unisul.aula.trabalho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//Pool de conexões

public class ConPooling {
	
	private static ConPooling connectionPooling;
	private ArrayList pooling;
	private String driver;
	private String user;
	private String password;
	private String url;
	private int nuConnection;

	 
	/**
	 * Construtor default.
	 */
	public ConPooling() {
		this.pooling = new ArrayList();
		Configuracao config = new Configuracao();
		this.driver = config.getDriver();
		this.user = config.getUser();
		this.password = config.getPassword();
		this.url = config.getUrl();
		try {
			Class.forName(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConPooling getInstance() {
		if (connectionPooling == null)
			connectionPooling = new ConPooling();
		return connectionPooling;
	}

	public synchronized Connection getConnection() {
		Connection connection = null;
		if (this.pooling.isEmpty()) {
			try {
				connection = DriverManager.getConnection(this.url, this.user, this.password);
				this.nuConnection++;
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"Não foi possível conectar ao banco de dados!",
						"ERRO!", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		} else {
			connection = (Connection) this.pooling.remove(0);
		}
		return connection;
	}

	public synchronized void retConnection(Connection con) {
		try {
			if (!con.getAutoCommit()) {
				con.rollback();
				con.setAutoCommit(true);
			}
			this.pooling.add(con);
		} catch (Exception e) {
			
		}
	}
}
