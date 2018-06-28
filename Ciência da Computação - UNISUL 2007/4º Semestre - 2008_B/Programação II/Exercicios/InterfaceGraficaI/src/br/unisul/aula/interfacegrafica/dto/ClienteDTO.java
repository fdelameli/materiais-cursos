package br.unisul.aula.interfacegrafica.dto;



/**
 * Classe que representa um cliente,
 * ela expressa quais informações ele possui.
 * @author Fabio Dela Bruna
 * @since 14/08/2008.
 */
public class ClienteDTO {

	private long codigo;
	private String nome;
	private String cpf;
	private String rg;
	private char sexo;
	private String email;
	private String fone;
	private String celular;
	private String endereco;
	private String cidade;
	private int uf;
	private int status;
	
	
	/**
	 * Construtor default.
	 */
	public ClienteDTO() {
		super();
	}
	
	
	/**
	 * Sobrescrita do método equals, para comparar se
	 * dos objetos do tipo ClienteDTO são iguais.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj instanceof ClienteDTO) {
			ClienteDTO c = (ClienteDTO) obj;
			return this.cpf.equals(c.getCpf())
				&& this.rg.equals(c.getRg());
		}
		return false;
	}
	
	
	// getters e setters

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getUf() {
		return uf;
	}

	public void setUf(int uf) {
		this.uf = uf;
	}
}
