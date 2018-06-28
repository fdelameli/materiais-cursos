package revenda.domain;

import framework.domain.DomainBase;

public class Login extends DomainBase {

	private String login;
	private String senha;
	
	
	/**
	 * Construtor defautl.
	 */
	public Login() {

	}
	
	
	// GETTERS E SETTERS
	
	public String getLogin() {
		return login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
