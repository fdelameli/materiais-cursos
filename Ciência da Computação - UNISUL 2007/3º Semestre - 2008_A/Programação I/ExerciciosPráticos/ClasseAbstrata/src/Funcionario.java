/**
 * Classe abstrata.
 * @author Fabio Dela Bruna
 * @since 06/05/2008
 */
public abstract class Funcionario {

	private String nome;
	private String sobrenome;
	private String cpf;
	
	
	/**
	 * @param nome
	 * @param sobrenome
	 * @param cpf
	 */
	public Funcionario(String nome, String sobrenome, String cpf) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
	}
	
	
	// método abstract
	
	/**
	 * Calcula o salário de um funcionário
	 * @return total calculado do salario
	 */
	public abstract double salario();

	
	// getters e setters
	
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
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	
	/**
	 * @param sobrenome the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	
	// toString
	
	public String toString(){
		return String.format("Nome: %s %s \nCPF: %s", nome, sobrenome, cpf);
	}
	
}
