package br.unisul.aula.trabalho.dao;

public class Configuracao extends Object {

	private String driver;
	private String user;
	private String password;
	private String url;


	/**
	 * Construtor default.
	 */
	public Configuracao() {

		this.driver = "org.postgresql.Driver";
		this.user = "postgres";
		this.password = "roger";
		this.url = "jdbc:postgresql://127.0.0.1/teste";

	}

	/*
	 * public Configuracao() { driver = "com.mysql.jdbc.Driver"; user = "root";
	 * password = "root";
	 * 
	 * dbURL = "jdbc:mysql://127.0.0.1/bancotcc"; }
	 */

	public String getDriver() {
		return this.driver;
	}

	public String getUser() {
		return this.user;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUrl() {
		return this.url;
	}

}
