package br.unisul.rodrigo.login;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe responsável por retornar informações
 * sobre o arquivo de propriedades.
 * @author Fabio Dela Bruna.
 * @since 24/06/2009.
 */
public class VerificaLogin {

	
	/**
	 * Construtor default.
	 */
	public VerificaLogin() {
		
	}
	
	
	/**
	 * Carrega as informações de usuário do arquivo de configurações.
	 */
	public String getUserProperties() throws IOException {
		Properties prop = new Properties();
		try {
			prop.load( VerificaLogin.class.getResourceAsStream("/conf/conf.properties") );
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException ("Não foi possível carregar o arquivo de propriedades");
			
		}
		return prop.getProperty("user");
	}
	
	
	/**
	 * Carrega as informações de senha do arquivo de configurações. 
	 */
	public String getPasswordProperties() throws IOException {
		Properties prop = new Properties();
		try {
			prop.load( VerificaLogin.class.getResourceAsStream("/conf/conf.properties") );
		} catch (IOException e) {
			throw new IOException ("Não foi possível carregar o arquivo de propriedades");
		}
		return prop.getProperty("password");
	}
	
	public static void main(String[] args) {
		VerificaLogin vl = new VerificaLogin();
		try {
			System.out.println(vl.getUserProperties());
			System.err.println(vl.getPasswordProperties());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
