package br.unisul.aula.dto;

public class Pessoa {

	private String nome;
	private int idade;
	private char sexo;
	private String nacionalidade;
	private Endereco endereco;
	private boolean disponivel;

	public Pessoa() {
		super();

	}

	public Pessoa(String nome, int idade, char sexo, String nacionalidade,
			Endereco endereco, boolean disponivel) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.nacionalidade = nacionalidade;
		this.endereco = endereco;
		this.disponivel = disponivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

}
