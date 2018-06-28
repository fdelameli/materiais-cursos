package br.unisul.aula.exemplorevenda.entidade;


/**
 * Entidade Funcionario
 * @author Fabio Dela Bruna
 * @since 22/04/2008
 */
public class Funcionario extends DadosPessoais {

	// atributos
	
	private String dataAdmissao;
	private float salario;
	private double comissao;
	
	
	// construtores
	
	/**
	 * Construtor default.
	 */
	public Funcionario() {
		super();
	}
	
	/**
	 * Construtor com parâmetros (com dados dos funcionários).
	 * @param dataAdmissao - Data de admissão.
	 * @param salario - Salário.
	 * @param comissao - Comissão.
	 */
	public Funcionario(String dataAdmissao, float salario, double comissao) {
		super();
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
		this.comissao = comissao;
	}


	// getters e setters

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	
	
	// toString
	
	public String toString(){
		return String.format("%s\nData de Admissão: %s\nSalário: %s\nComissão: %s", super.toString(), dataAdmissao, salario, comissao);
	}
}
