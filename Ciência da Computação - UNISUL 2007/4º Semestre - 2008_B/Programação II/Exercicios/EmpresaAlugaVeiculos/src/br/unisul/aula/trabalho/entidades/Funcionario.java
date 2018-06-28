package br.unisul.aula.trabalho.entidades;

import java.util.GregorianCalendar;


/**
 * Entidade Funcionario.
 * @author Fabio Dela Bruna, Marcio Ozório Teixeira.
 * @since 12/05/2008
 */
public class Funcionario extends DadosPessoais {

	// attributes
	
	private GregorianCalendar dataAdmissao;
	
	
	// constructors
	
	/**
	 * Construtor default.
	 */
	public Funcionario() {
		super();
	}
	
	/**
	 * construtor com parâmetros.
	 */
	public Funcionario(long codigo, String nome, String sobrenome, String cpf, String rg,
			char sexo, Endereco endereco, GregorianCalendar dataNascimento, String fone1,
			String fone2, GregorianCalendar dataAdmissao) {
		
		super(codigo, nome, sobrenome, cpf, rg, sexo, endereco, dataNascimento, fone1, fone2);
		this.dataAdmissao = dataAdmissao;
	}

	
	//main methods
	
	/**
	 * Método para calcular o salário dos funcionários.
	 * Para um funcionario comum, os salário é simplesmente seu salario mensal.
	 * Já para o funcionario exta (por exemplo, uma faxineira, que não trabalha
	 * durante todo o período) se salário é de acordo com a quantidade de horas trabalhadas.
	 */
	public double calculaSalario() {
		return 0;
	}

	
	// getters e setters

	public String getDataAdmissao() {
		String data = this.dataAdmissao.get(GregorianCalendar.DAY_OF_MONTH)
		+ "/" + this.dataAdmissao.get(GregorianCalendar.MONTH)
		+ "/" + this.dataAdmissao.get(GregorianCalendar.YEAR);
		return data;
	}

	public void setDataAdmissao(GregorianCalendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	
	//equals e toString
	
	public boolean equals(Object obj) {
		if(this == null)
			return true;
		if(obj instanceof Funcionario) {
			Funcionario f = (Funcionario) obj;
			return (this.getCpf().equals(f.getCpf())
			&& this.getDataAdmissao() == f.getDataAdmissao());
		}
	return false;
	}
	
	public String toString(){
		return String.format("<<< DADOS FUNCIONÁRIO >>>\n%s\nData de Admissão: %s",
				super.toString(), getDataAdmissao());
	}
}
