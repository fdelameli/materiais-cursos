package meubanco.domain;

public class Pessoa {

	private Integer cdPessoa;
	private String nmPessoa;
	
	
	/**
	 * Construtor default.
	 */
	public Pessoa() {
		
	}
	
	
	/**
	 * Método toString.
	 */
	public String toString() {
		return String.format("%s   -   %s", getCdPessoa(), getNmPessoa());
	}
	
	
	// Getters e Setters
	
	
	public Integer getCdPessoa() {
		return cdPessoa;
	}
	
	public void setCdPessoa(Integer cdPessoa) {
		this.cdPessoa = cdPessoa;
	}
	
	public String getNmPessoa() {
		return nmPessoa;
	}
	
	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}
	
}
