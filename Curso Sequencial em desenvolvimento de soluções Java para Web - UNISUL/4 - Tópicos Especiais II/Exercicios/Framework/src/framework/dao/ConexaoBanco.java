package framework.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConexaoBanco {

	
	private Connection con = null;
	private static ConexaoBanco instance = null;
	
	
	
	private ConexaoBanco () {
		
	}
	
	
	/**
	 * Cria uma instancia da classe conexaoBanco.
	 */
	public static ConexaoBanco getInstance() {
		if (instance == null) {
			instance = new ConexaoBanco();
		}
		return instance;
	}
	
	/**
	 * Carrega as configuracoes de acesso ao banco do arquivo de propriedades
	 * e cabre a conexao com o banco de dados.
	 * @throws Exception
	 */
	private void createConnection() throws Exception {
		
		Properties properties = new Properties();
		
		try {
			properties.load(ConexaoBanco.class.getResourceAsStream("/conf/conexaoBanco.properties"));
		}catch (IOException e){
			throw new Exception ("Nao foi possivel carregar o arquivo de propriedades");
		}
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException e) {
			throw new Exception ("Nao foi possivel carregar o driver JDBC");
		}
	}

	/**
	 * Metodo para pegar a conexao.
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		
		if (con == null || con.isClosed()) {
			createConnection();
		}
		return con;
	}
	
	/**
	 * Metodo para fechar a conexao.
	 * @throws Exception
	 */
	public void closeConnection() throws Exception {
		
		if (con != null && !con.isClosed()) {
			con.close();
		}
	}
	
	
}