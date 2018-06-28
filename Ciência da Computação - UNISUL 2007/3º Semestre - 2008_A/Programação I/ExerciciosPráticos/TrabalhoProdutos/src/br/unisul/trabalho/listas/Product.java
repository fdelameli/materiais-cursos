package br.unisul.trabalho.listas;


/**
 * Classe que representa um produto.
 * @author Fabio Dela Bruna.
 * @since 16/03/2008.
 */
public class Product  {

	private String nomeProduto;
	private double valor;
	private double peso;
	private String dataValidade;

	/**
	 * Construtor default.
	 */
	public Product() {
		super();
	}

	/** 
	 * Construtor com parâmetros.
	 * @param nome Nome do produto.
	 * @param valor Valor do produto.
	 * @param peso Peso do produto (em gramas).
	 * @param dataValidade Data de Validade do produto (__/__/__).
	 */
	public Product(String nomeProduto, double valor, double peso, String dataValidade) {
		super();
		this.nomeProduto = nomeProduto;
		this.valor = valor;
		this.peso = peso;
		this.dataValidade = dataValidade;
	}

	
	/**
	 * Método toString.
	 */
	public String toString(){
        return "PRODUTO: " + this.nomeProduto
        	+ "\nVALOR: R$ " + this.valor
            + "\nPESO " + this.peso 
            + "\nDATA DE VALIDADE: " + this.dataValidade;
		}



	/**
	 * @return the dataValidade
	 */
	public String getDataValidade() {
		return dataValidade;
	}

	
	/**
	 * @param dataValidade the dataValidade to set
	 */
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	
	/**
	 * @return the nomeProduto
	 */
	public String getNomeProduto() {
		return nomeProduto;
	}

	
	/**
	 * @param nomeProduto the nomeProduto to set
	 */
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	
	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}

	
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
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