package aula02.array.exercicios.exe06;

/**
 * Classe que representa uma pessoa
 * @author Fabio Dela Bruna
 * @since 12/04/2008
 */
public class Pessoa {
	
	
	
	private String nome;
	private byte idade;
	private char sexo;
	
	
	// Construtor
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, byte idade, char sexo) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

}
