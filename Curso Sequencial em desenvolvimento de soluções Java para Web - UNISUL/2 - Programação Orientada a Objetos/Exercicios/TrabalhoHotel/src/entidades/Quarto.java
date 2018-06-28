package entidades;

/**
 * Classe que representa um quarto. 
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 */
public abstract class Quarto {
	
	//atributos
	
	private int qtdPessoas;
	private double valorDiaria;
	
	
	//construtores
	
	/**
	 * Construtor default.
	 */
	public Quarto() {
		super();
	}


	/**
	 * Construtor com parâmetros.
	 * @param qtdPessoas - Quantidades de pessoas.
	 * @param valorDiaria - Valor da Diária.
	 */
	public Quarto(int qtdPessoas, double valorDiaria) {
		super();
		this.qtdPessoas = qtdPessoas;
		this.valorDiaria = valorDiaria;
	}

	
	//métodos principais

	/**
	 * Método para pegar o tipo do quarto.
	 */
	public abstract String getTipoQuarto();
	
	
	//getters e setters
	
	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	
	//toString
	
	public String toString(){
		return String.format("Qtd Pessoas: %s\nValor Diária: %s", this.qtdPessoas, this.valorDiaria );
	}
	

}