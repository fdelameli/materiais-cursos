package br.unisul.aula.trabalho.entidades;

import java.util.*;

/**
 * Classe que contém os dados pessoais.
 * @author Fabio Dela Bruna.
 * @since 12/05/2008
 */
public class DadosPessoais {

	// atributos
	
	private long codigo;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String rg;
	private char sexo;
	private Endereco endereco;
	private GregorianCalendar dataNascimento;
	private String fone1;
	private String fone2;
	
	
	// construtores
	
	/**
	 * Construtor padrão.
	 */
	public DadosPessoais() {
		super();	
	}
	
	/**
	 * Construtor com parâmetros (com os dados pessoais).
	 * @param codigo - Código da pessoa.
	 * @param nome - Nome.
	 * @param sobrenome - Sobrenome;
	 * @param cpf - CPF.
	 * @param rg - Identidade.
	 * @param sexo - Sexo.
	 * @param endereco - Endereço residencial.
	 * @param cidade - Cidade.
	 * @param dataNascimento - Data de nascimento.
	 * @param fone1 - Telefone 1.
	 * @param fone2 - Telefone 2.
	 */
	public DadosPessoais(long codigo, String nome, String sobrenome, String cpf, String rg, char sexo,
			Endereco endereco,GregorianCalendar dataNascimento, String fone1, String fone2) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.fone1 = fone1;
		this.fone2 = fone2;
	}


	// getters e setters

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getDataNascimento() {
		String data = this.dataNascimento.get(GregorianCalendar.DAY_OF_MONTH)
		+ "/" + this.dataNascimento.get(GregorianCalendar.MONTH)
		+ "/" + this.dataNascimento.get(GregorianCalendar.YEAR);
		return data;
	}

	public void setDataNascimento(GregorianCalendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public String getFone2() {
		return fone2;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}	
	
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	
	// toString
	
	public String toString(){
		return String.format("Código: %s\nNome: %s %s\nCPF: %s\nTelefone: %s",
				this.codigo, this.nome, this.sobrenome, this.cpf, this.fone1);
	}
}
