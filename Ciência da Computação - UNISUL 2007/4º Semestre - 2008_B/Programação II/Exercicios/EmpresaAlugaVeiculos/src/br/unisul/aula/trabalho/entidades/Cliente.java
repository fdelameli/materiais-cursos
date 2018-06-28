package br.unisul.aula.trabalho.entidades;

import java.util.ArrayList;
import java.util.GregorianCalendar;


/**
 * Entidade Cliente.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 * @since 12/05/2008
 */
public class Cliente extends DadosPessoais {

	//attributes
	
	private String numeroCartaoCredito;
	private ArrayList<Aluguel> alugueis;

	
	//constructors
	
	/**
	 * Construtor default
	 */
	public Cliente() {
		super();
		this.numeroCartaoCredito = "";
		this.alugueis = new ArrayList<Aluguel>();
	}

	/**
	 * Construtor com parâmetros.
	 **/
	public Cliente(long codigo, String nome, String sobrenome, String cpf, String rg, char sexo, Endereco endereco,
			GregorianCalendar dataNascimento, String fone1, String fone2, String numeroCartaoCredito) {
		
		super(codigo, nome, sobrenome, cpf, rg, sexo, endereco, dataNascimento, fone1, fone2);
		this.numeroCartaoCredito = numeroCartaoCredito;
		this.alugueis = new ArrayList<Aluguel>();
	}

	
	//getters e setters
	
	public String getNumeroCartaoCredito() {
		return numeroCartaoCredito;
	}

	public void setNumeroCartaoCredito(String numeroCartaoCredito) {
		this.numeroCartaoCredito = numeroCartaoCredito;
	}

	public ArrayList<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(ArrayList<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	
	
	// equals e toString
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Cliente) {
			Cliente cliente = (Cliente) obj;
			return (this.getCpf().equals(cliente.getCpf()));
		}
		return false;
	}
	
	public String toString(){
		return String.format("<<< DADOS CLIENTE >>>\n%s\nNúmero Cartão de Crédito: %s\n",
				super.toString(), this.numeroCartaoCredito);
	}
}
