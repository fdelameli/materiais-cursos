package com.br.lhmanager.controller.entitys;

import java.util.ArrayList;

/**
 * Classe que representa um usuário do sistema.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
public class Usuario implements ICrudBase {

	// Atributos

	/**
	 * Login do usuário para acessar o sistema.
	 */
	private String login;

	/**
	 * Senha do usuário para acessar o sistema.
	 */
	private String senha;

	/**
	 * Nome do usuário.
	 */
	private String nome;

	/**
	 * Telefone do usuário.
	 */
	private String telefone;

	// Construtores

	/**
	 * Construtor sem parâmetros (padrão).
	 */
	public Usuario() {
		this("", "", "", "");
	}

	/**
	 * Construtor com parâmetros.
	 * 
	 * @param login
	 *            Login do usuário para acessar o sistema.
	 * @param senha
	 *            Senha do usuário para acessar o sistema.
	 * @param nome
	 *            Nome do usuário.
	 * @param telefone
	 *            Telefone do usuário.
	 */
	public Usuario(String login, String senha, String nome,
			String telefone) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.telefone = telefone;
	}

	// Métodos de manutenção de acesso ao sistema.

	public boolean alterarLogin(String login) {
		return false;
	}

	public boolean alterarSenha(String senha) {
		return false;
	}

	// Métodos de persistência.

	@Override
	public boolean atualizar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inserir(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Usuario> listar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	// toString
	@Override
	public String toString() {
		return String.format("Login: %s\nNome: %s\nTelefone: %s\n", getLogin(),
				getSenha(), getTelefone());
	}

	// Getters e Setters

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
