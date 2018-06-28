package br.unisul.aula.exemplorevenda.entidade;

import java.util.Date;

/**
 * Entidade Cliente
 * @author Fabio Dela Bruna
 * @since 22/04/2008
 */
public class Cliente extends DadosPessoais {
		
	// atributos
	
	private Date dataCadastro;
	private char classificacao; // A-Bom  _  B-Médio  _  C-Ruim
	
	
	// construtores
	
	/**
	 * Construtor default;
	 */
	public Cliente() {
		super();
	}
	
	/**
	 * Construtor com parâmetros (com dados do cliente).
	 * @param dataCadastro - Data de cadastro.
	 * @param classificacao - classificação do cliente.
	 */
	public Cliente(Date dataCadastro, char classificacao) {
		super();
		this.dataCadastro = dataCadastro;
		this.classificacao = classificacao;
	}


	// getters e setters

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public char getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(char classificacao) {
		this.classificacao = classificacao;
	}
	
	
	// toString
	
	public String toString(){
		return String.format("%s\nData de cadastro: %s\nClassificação: %s", super.toString(), this.dataCadastro, this.classificacao);
	}

}
