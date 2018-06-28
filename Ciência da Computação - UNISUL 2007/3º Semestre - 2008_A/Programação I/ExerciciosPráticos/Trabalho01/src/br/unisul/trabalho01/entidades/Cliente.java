


/**
 * Classe que representa um Cliente.
 * @author Fabio Dela Bruna, Márcio Ozório.
 * @since 31/03/2008.
 */
public class Cliente extends Pessoa {

	
	// Atributos
	
	private int cartao_credito;
	/**
	 * Atributos
	 */
	private int cartaoCredito;

	
	// Construtores
	
	/**
	 * Construtor default.
	 */
	public Cliente(){
		super();
	}

	/**
	 * Construtor com parâmetros (com dados do cliente).
	 * @param data_nascimento - Data de Nascimento;
	 * @param nome - Nome;
	 * @param cpf - CPF;
	 * @param rg - RG;
	 * @param endereco - Endereço;
	 * @param cartao_credito - Nº do Cartão de Crédito;
	 */
	public Cliente(String data_nascimento, String nome, String cpf, String rg, Endereco endereco, int cartao_credito) {
		super(data_nascimento, nome, cpf, rg, endereco);
		this.cartao_credito = cartao_credito;
	}
	
	
	// Getters e Setters
	
	/**
	 * @return the cartao_credito
	 */
	public int getCartao_credito() {
		return cartao_credito;
	}

	/**
	 * @param cartao_credito the cartao_credito to set
	 */
	public void setCartao_credito(int cartao_credito) {
		this.cartao_credito = cartao_credito;
	}

	
	// toString
	
	/**
	 * Método para mostrar os clientes cadastrados.
	 */
	public String toString(){
		return "\nData Nascimento: " + super.getDataNascimento() + "\nNome: " + super.getNome() + "\nCPF: " + super.getCpf() + "\nRG: " + super.getRg() + "\nEndereco: " + super.getEndereco() + "\nCartão de Crédito: " + this.cartao_credito;
	}
}