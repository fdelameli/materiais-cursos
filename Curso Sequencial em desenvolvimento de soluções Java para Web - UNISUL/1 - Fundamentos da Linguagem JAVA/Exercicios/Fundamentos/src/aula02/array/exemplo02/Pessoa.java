package aula02.array.exemplo02;

public class Pessoa {

	private String nome;
	private byte idade;
	
	
	// Construtores
	
	public Pessoa(String nome, byte idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}


	// Getters e Setters
	
	public byte getIdade() {
		return idade;
	}

	public void setIdade(byte idade) {
		this.idade = idade;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
