package meubanco.domain;

import framework.domain.DomainBase;

public class Funcionario extends DomainBase {

	private Integer cdFuncionario;
	private Double salario;
	private Integer cdPessoa;
	
	private Pessoa pessoa;
	
	
	
	
	// GETTERS E SETTERS

	public Integer getCdFuncionario() {
		return cdFuncionario;
	}

	public void setCdFuncionario(Integer cdFuncionario) {
		this.cdFuncionario = cdFuncionario;
	}

	public Integer getCdPessoa() {
		return cdPessoa;
	}

	public void setCdPessoa(Integer cdPessoa) {
		this.cdPessoa = cdPessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
}
