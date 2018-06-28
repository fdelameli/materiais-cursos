package br.unisul.aula.trabalho.entidades;

import java.util.GregorianCalendar;


/**
 * Entidade Funcionario Comum.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 * @since 12/05/2008
 */
public class FuncionarioComum extends Funcionario {
	
	//attributes
	
	private double salario;

	
	//constructors
	
	/**
	 * Construtor default.
	 */
	public FuncionarioComum() {
		super();
	}

	/**
	 * Construtor com parâmetros.
	 */
	public FuncionarioComum(long codigo, String nome, String sobrenome, String cpf, String rg,
			char sexo, Endereco endereco, GregorianCalendar dataNascimento, String fone1,
			String fone2, GregorianCalendar dataAdmissao, double salario) {
		
		super(codigo, nome, sobrenome, cpf, rg, sexo, endereco, dataNascimento, fone1, fone2, dataAdmissao);
		this.salario = salario;
	}

	
	//main methods
	
	@Override
	public double calculaSalario() {
		return this.salario;
	}

	
	//getters e setters
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	
	//toString
	
	public String toString() {
		return String.format("%s\nSalário: %s\n", super.toString(), calculaSalario());
	}
}
