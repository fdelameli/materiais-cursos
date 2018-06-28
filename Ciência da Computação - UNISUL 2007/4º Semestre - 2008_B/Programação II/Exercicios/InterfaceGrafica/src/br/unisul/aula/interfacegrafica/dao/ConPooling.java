package br.unisul.aula.interfacegrafica.dao;

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

	private String dbURL;

	private int nuConnection;

	public ConPooling() {
		pooling = new ArrayList();
		Configuracao config = new Configuracao();
		driver = config.getDriver();
		user = config.getUser();
		password = config.getPassword();
		dbURL = config.getUrl();
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConPooling getInstance() {
		if (connectionPooling == null)
			connectionPooling = new ConPooling();
		return connectionPooling;
	}

	public synchronized Connection getConnection() throws DAOException {
		Connection connection = null;
		if (pooling.isEmpty()) {
			try {
				connection = DriverManager.getConnection(dbURL, user, password);
				nuConnection++;
			} catch (SQLException e) {
				throw new DAOException("Não foi possível conectar ao banco de dado:\n" + e.getMessage());
			}
		} else {
			connection = (Connection) pooling.remove(0);
		}
		return connection;
	}

	public synchronized void retConnection(Connection con) throws DAOException {
		try {
			if (!con.getAutoCommit()) {
				con.rollback();
				con.setAutoCommit(true);
			}
			pooling.add(con);
		} catch (Exception e) {
			throw new DAOException("Não foi possível devolver a conexão:\n" + e.getMessage());
		}
	}
}
