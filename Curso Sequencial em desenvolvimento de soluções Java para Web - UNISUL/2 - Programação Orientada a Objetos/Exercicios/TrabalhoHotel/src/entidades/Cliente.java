package entidades;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Classe que representa um cliente.
 * @author Fabio Dela Bruna / Carlos Henrique Sá
 */
public abstract class Cliente {
	
	//atributos
	
	private int codigo;
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
	public Cliente(int codigo, String nome, String sobrenome, String cpf, Endereco endereco,GregorianCalendar dataNascimento,
			String fone1, String fone2, ArrayList<Estadia> estadias) {
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

	
	//métodos abstratos
	
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
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		String data = this.dataNascimento.get(GregorianCalendar.DAY_OF_MONTH)
		+ "/" + this.dataNascimento.get(GregorianCalendar.MONTH)
		+ "/" + this.dataNascimento.get(GregorianCalendar.YEAR);
		return data;	
	}

	public void setDataNascimento(GregorianCalendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public String getFone2() {
		return fone2;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setEstadias(ArrayList<Estadia> estadias) {
		this.estadias = estadias;
	}

	public ArrayList<Estadia> getEstadias() {
		return estadias;
	}
	
	
	//toString
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Cliente) {
			Cliente c = (Cliente) obj;
			return this.nome.equals(c.getNome())
				&& this.sobrenome.equals(c.getSobrenome());
		}
		return false;
	}
	
	//to String
	
	public String toString(){
		return String.format("Nome Completo: %s %s\nCPF: %s\nData Nascimento: %s\nTelefone: %s\n\n<<ESTADIAS>>\n%s\n",
				this.nome, this.sobrenome, this.cpf, getDataNascimento(), this.fone1, estadias);
	}
	


		
}