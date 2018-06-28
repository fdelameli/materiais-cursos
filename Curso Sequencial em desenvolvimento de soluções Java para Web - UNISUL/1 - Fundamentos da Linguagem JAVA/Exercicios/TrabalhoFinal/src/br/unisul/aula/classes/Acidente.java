package br.unisul.aula.classes;

/**
 * Classe que representa um acidente
 * 
 * @author Fabio Dela Bruna
 * @since 17/04/2008
 */
public class Acidente {

	
	// Atributos
	
	private Pessoa pessoa;
	private String data;
	private byte tipoVeiculo; // 1-Automóvel, 2-Motocicleta, 3-Bicicleta.
	private boolean vitimasFatais; // 1-SIM / 0-NAO
	
	
	// Construtor
	
	public Acidente() {
		super();
	}
	
	/**
	 * Construtor com parâmetros (com dados do acidente)
	 * @param pessoa - Pessoa envolvida no acidente.
	 * @param data - Data do acidente.
	 * @param tipoVeiculo  - Tipo do veículo envolvido no acidente.
	 * @param vitimasFatais  - Se ouve vítimas fatais.
	 */
	public Acidente(Pessoa pessoa, String data, byte tipoVeiculo, boolean vitimasFatais) {
		super();
		this.pessoa = new Pessoa();
		this.data = data;
		this.tipoVeiculo = tipoVeiculo;
		this.vitimasFatais = vitimasFatais;
	}
	
	
	
	// Getters e Setters
	
	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}	

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * @return the vitimasFatais
	 */
	public boolean isVitimasFatais() {
		return vitimasFatais;
	}
	
	/**
	 * @param vitimasFatais the vitimasFatais to set
	 */
	public void setVitimasFatais(boolean vitimasFatais) {
		this.vitimasFatais = vitimasFatais;
	}

	/**
	 * @param tipoVeiculo the tipoVeiculo to set
	 */
	public void setTipoVeiculo(byte tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	
	/**
	 * @return the tipoVeiculo
	 */
	public byte getTipoVeiculo() {
		return tipoVeiculo;
	}
	
}
