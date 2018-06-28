package aula03.arrayList.exercicios.exe01;

public class Produto {

	
	private String nome;
	private double valor;
	private byte rotatividade;
	
	
	/**
	 * 
	 */
	public Produto() {
		super();
	}


	/**
	 * @param nome
	 * @param valor
	 * @param rotatividade
	 */
	public Produto(String nome, double valor, byte rotatividade) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.rotatividade = rotatividade;
	}

	
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the rotatividade
	 */
	public byte getRotatividade() {
		return rotatividade;
	}

	/**
	 * @param rotatividade the rotatividade to set
	 */
	public void setRotatividade(byte rotatividade) {
		this.rotatividade = rotatividade;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
