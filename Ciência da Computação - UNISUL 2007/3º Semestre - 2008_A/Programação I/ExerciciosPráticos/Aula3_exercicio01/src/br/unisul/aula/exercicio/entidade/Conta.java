package br.unisul.aula.exercicio.entidade;


/**
 * Classe que representa uma conta em um contexto bancario
 * 
 * @author Fabio Dela Bruna
 * @since 04/03/2008
 */
public class Conta {

	private String agencia;
	private String numeroConta;
	private String senha;
	private double saldo;
	private String historico;
	
	/**
	 * Construtor default
	 */
	public Conta() {
		super();

	}
	
	
	/**
	 * Construtor com parametros
	 * @param agencia Numero da Angencia do Banco
	 * @param numeroConta Numero da conta
	 * @param senha Senha da conta
	 */
	public Conta(String agencia, String numeroConta, String senha, double saldo) {
		super();
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.senha = senha;
		this.saldo = saldo;
		this.historico = historico;
	}


	/**
	 * @return the agencia
	 */
	public String getAgencia() {
		return agencia;
	}


	/**
	 * @param agencia the agencia to set
	 */
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}


	/**
	 * @return the numeroConta
	 */
	public String getNumeroConta() {
		return numeroConta;
	}


	/**
	 * @param numeroConta the numeroConta to set
	 */
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}


	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}


	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}


	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}


	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	public String getHistorico(){
		return historico;
	}
	
	
	public void setHistorico(String historico){
		this.historico = historico;
	}
}
