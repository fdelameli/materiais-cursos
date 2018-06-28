package br.unisul.aula.interfacegrafica.dao;

public class Configuracao extends Object {

	private String driver;

	private String user;

	private String password;

	private String url;

	/* CONFIGURAÇÃO PARA O MYSQL */
	/*
	 * //driver para clausulas normais driver = "org.gjt.mm.mysql.Driver";
	 * 
	 * //driver para o jdeveloper driver = "com.mysql.jdbc.Driver";
	 * 
	 * user = "root"; password = "roger";
	 * 
	 * dbURL = "jdbc:mysql://127.0.0.1/bibliasagrada";
	 */

	/* CONFIGURAÇÃO PARA O INTERBASE */
	/*
	 * driver = "org.firebirdsql.jdbc.FBDriver"; user = "SYSDBA"; password =
	 * "masterkey";
	 * 
	 * dbURL =
	 * "jdbc:firebirdsql:127.0.0.1/3050:D:/HEVistorias/BaseDados/VISTORIA.GDB";
	 */

	/* CONFIGURAÇÃO PARA O POSTGRESQL */
	public Configuracao() {

		this.driver = "org.postgresql.Driver";
		this.user = "postgres";
		this.password = "postgres";

		this.url = "jdbc:postgresql://127.0.0.1/hotel";

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
