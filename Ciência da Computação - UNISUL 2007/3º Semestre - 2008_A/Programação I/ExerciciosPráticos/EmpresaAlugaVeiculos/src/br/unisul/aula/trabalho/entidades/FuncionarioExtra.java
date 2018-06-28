package br.unisul.aula.trabalho.entidades;

import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Entidade Funcionario Extra.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 * @since 12/05/2008
 */
public class FuncionarioExtra extends Funcionario{

	//attributes
	
	private double qtdHorasTrabalhadas;
	private double valorHora;
	
	
	//constructors
	
	/**
	 * Construtor default.
	 */
	public FuncionarioExtra() {
		super();
		this.qtdHorasTrabalhadas = 0;
		this.valorHora = 0;
	}
	
	/**
	 * Construtor com parâmetros.
	 */
	public FuncionarioExtra(long codigo, String nome, String sobrenome, String cpf, String rg, char sexo,
			Endereco endereco, GregorianCalendar dataNascimento, String fone1, String fone2,
			GregorianCalendar dataAdmissao, double qtdHorasTrabalhadas, double valorHora) {
		
		super(codigo, nome, sobrenome, cpf, rg, sexo, endereco, dataNascimento, fone1, fone2, dataAdmissao);
		this.qtdHorasTrabalhadas = qtdHorasTrabalhadas;
		this.valorHora = valorHora;
	}

	
	//main method
	
	@Override
	public double calculaSalario() {
		return this.qtdHorasTrabalhadas * this.valorHora;
	}

	
	//getters e setters
	
	public double getQtdHorasTrabalhadas() {
		return qtdHorasTrabalhadas;
	}

	public void setQtdHorasTrabalhadas(double qtdHorasTrabalhadas) {
		this.qtdHorasTrabalhadas = qtdHorasTrabalhadas;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	
	
	//toString
	
	public String toString() {
		return String.format("%s\nQtd Horas Trabalhadas: %s   --> Valor Hora: %s\nSalário: %s\n",
				super.toString(), this.qtdHorasTrabalhadas, this.valorHora, calculaSalario());
	}
}
