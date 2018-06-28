package br.unisul.aula.exemplorevenda.entidade;

import java.util.*;

/**
 * Classe que contém os dados pessoais.
 * @author Fabio Dela Bruna.
 * @since 22/04/2008
 */
public class DadosPessoais {

	// atributos
	
	private long codigo;
	private String nome;
	private String cpf;
	private String rg;
	private char sexo;
	private String endereco;
	private Cidade cidade;
	private Date dataNascimento;
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
	 * @param cpf - CPF.
	 * @param rg - Identidade.
	 * @param sexo - Sexo.
	 * @param endereco - Endereço residencial.
	 * @param cidade - Cidade.
	 * @param dataNascimento - Data de nascimento.
	 * @param fone1 - Telefone 1.
	 * @param fone2 - Telefone 2.
	 */
	public DadosPessoais(long codigo, String nome, String cpf, String rg, char sexo, String endereco, Cidade cidade, Date dataNascimento, String fone1, String fone2) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.endereco = endereco;
		this.cidade = cidade;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
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
	
	
	// toString
	
	public String toString(){
		return String.format("Código: %s\nNome: %s\nCPF: %s\nEndereço: %s\nTelefone: %s", this.codigo, this.nome, this.cpf, this.endereco, this.fone1);
	}
}
