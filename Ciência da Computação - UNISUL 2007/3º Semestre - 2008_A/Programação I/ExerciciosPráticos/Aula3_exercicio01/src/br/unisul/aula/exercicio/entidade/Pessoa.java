package br.unisul.aula.exercicio.entidade;


/**
 * Classe que representa uma pessoa no contexto bancario
 * 
 * @author Fabio Dela Bruna
 * @since 04/03/2008
 */
public class Pessoa {

	private String nome;
	private int idade;
	private char sexo;
	private Conta conta;
	
	
	/**
	 * Construtor default
	 */
	public Pessoa() {
		super();
		
	}
	
	
	/**
	 * Construtor com parametros
	 * @param n Nome
	 * @param i Idade
	 * @param s Sexo
	 */
	public Pessoa(String nome, int idade, char sexo){
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}


	/**
	 * Construtor com patametros
	 * @param nome Nome
	 * @param idade Idade
	 * @param sexo Sexo
	 * @param conta Conta
	 */
	public Pessoa(String nome, int idade, char sexo, Conta conta) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.conta = conta;
	}


	/**
	 * @return the idade
	 */
	public int getIdade() {
		return idade;
	}


	/**
	 * @param idade the idade to set
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}


	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/**
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}


	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	/**
	 * @return the conta
	 */
	public Conta getConta() {
		return conta;
	}


	/**
	 * @param conta the conta to set
	 */
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
