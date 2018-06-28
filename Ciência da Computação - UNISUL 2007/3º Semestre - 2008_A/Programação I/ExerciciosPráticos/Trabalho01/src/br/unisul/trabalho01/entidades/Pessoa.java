
/**
 * Classe que representa uma Pessoa.
 * @author Fabio Dela Bruna, Márcio Ozório.
 * @since 30/03/2008.
 */
public class Pessoa {

	
	// Atributos
	
	private String dataNascimento;
	private String nome;
	private String cpf;
	private String rg;
	private Endereco endereco;

	
	//Contrutores
	
	/**
	 * Construtor default.
	 */
	public Pessoa() {
		super();
	}
	
	/**
	 * Construtor com parametros (com dados de pessoa).
	 * @param data_nascimento - Data de Nascimento;
	 * @param nome - Nome;
	 * @param cpf - CPF;
	 * @param rg - RG;
	 * @param endereco - Endereço;
	 */
	public Pessoa(String dataNascimento, String nome, String cpf, String rg, Endereco endereco) {
		super();
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		
	}
	
	
	//	getters and setter
	
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the data_nascimento
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param data_nascimento the data_nascimento to set
	 */
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * @param rg the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	// equals e toString
	
	/**
	 * Método para mostrar os dados de pessoa.
	 */
	public String toString(){
		return "Data Nascimento: " + dataNascimento + "Nome: " + nome + "CPF: " + cpf + "RG: " + "Endereco: " + endereco;
	}
	
	/**
	 * Método para verificar se determinada pessoa já esta cadastrada.
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Assento) {
			Pessoa pessoa = (Pessoa) obj;
			return this.cpf == pessoa.cpf;
		}
		return false;
	}	
}