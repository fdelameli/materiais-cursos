package entidades;


/**
 * Classe que representa um endereço.
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 */
public class Endereco {
	
	//atributos
	
	private int numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	
	
	//construtores
	
	/**
	 * Construtor default.
	 */
	public Endereco() {
		this(0, "", "", "", "");
	}
	
	/**
	 * Construtor com parâmetros.
	 * @param numero - Número da casa.
	 * @param rua - Rua.
	 * @param bairro - Bairro.
	 * @param cidade - Cidade.
	 * @param estado - Estado.
	 */
	public Endereco(int numero, String rua, String bairro, String cidade, String estado) {
		super();
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	
	//getters e setters
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
	
	//to String
	
	public String toString(){
		return String.format("Estado: %\nCidade: %s\nBairro: %s\n",
				this.estado, this.cidade, this.bairro);
	}
	
}