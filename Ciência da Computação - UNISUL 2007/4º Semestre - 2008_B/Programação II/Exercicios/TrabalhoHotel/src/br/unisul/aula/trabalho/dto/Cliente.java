package br.unisul.aula.trabalho.dto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe que representa um cliente.
 * @author Fabio Dela Bruna / Marcio Teixeira Ozório.
 * @since 13/05/2008.
 */
public abstract class Cliente {
	
	//atributos
	
	private String nome;
	private String sobrenome;
	private String cpf;
	private Endereco endereco;
	private GregorianCalendar dataNascimento;
	private String fone1;
	private String fone2;
	private ArrayList<Estadia> estadias;
	
	
	//construtores
	
	/**
	 * Construtor default
	 */
	public Cliente() {
		super();
		this.estadias = new ArrayList<Estadia>();
	}
	
	/**
	 * Construtor com parâmetros.
	 * @param nome - Nome do cliente.
	 * @param sobrenome - Sobrenome.
	 * @param cpf - Cadastro de pessoa física - CPF.
	 * @param endereco - Endereço completo.
	 * @param dataNascimento - Data de nascimento.
	 * @param fone1 - Telefone 1.
	 * @param fone2 - Telefone 2.
	 * @param estadias - ArrayList de estadias. 
	 */
	public Cliente(String nome, String sobrenome, String cpf, Endereco endereco, GregorianCalendar dataNascimento, String fone1, String fone2, ArrayList<Estadia> estadias) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.fone1 = fone1;
		this.fone2 = fone2;
		this.estadias = new ArrayList<Estadia>();
	}

	
	//método abstrato
	
	/**
	 * Método que calcula o valor das estadias.
	 * @return - O valor total da estadia.
	 */
	public abstract double calculaValorEstadia();
	
	
	/**
	 * Método para cadastrar uma estadia.
	 * @param e - Estadia.
	 */
	public abstract void cadastraEstadia(Estadia e);
	
	
	//getters e setters
	
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
	 * @return the dataNascimento
	 */
	public String getDataNascimento() {
		String data = this.dataNascimento.get(GregorianCalendar.DAY_OF_MONTH) +
				"-" + this.dataNascimento.get(GregorianCalendar.MONTH) +
				"-" + this.dataNascimento.get(GregorianCalendar.YEAR);
		return data;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(GregorianCalendar dataNascimento) {
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
	 * @return the fone1
	 */
	public String getFone1() {
		return fone1;
	}

	/**
	 * @param fone1 the fone1 to set
	 */
	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	/**
	 * @return the fone2
	 */
	public String getFone2() {
		return fone2;
	}

	/**
	 * @param fone2 the fone2 to set
	 */
	public void setFone2(String fone2) {
		this.fone2 = fone2;
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

	public void setEstadias(ArrayList<Estadia> estadias) {
		this.estadias = estadias;
	}

	public ArrayList<Estadia> getEstadias() {
		return estadias;
	}
	
	
	//to String
	
	public String toString(){
		return String.format("Nome Completo: %s %s\nCPF: %s\nData Nascimento: %s\nTelefone: %s\nEstadias: %s\n",
				this.nome, this.sobrenome, this.cpf, getDataNascimento(), this.fone1, estadias);
	}
	


		
}