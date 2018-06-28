package br.unisul.transportadora.bean;

/**
 * Classe Java que representa um usuario e seus atributos.
 * @author Fabio Dela Bruna
 */
public class UsuarioBean {

	// Atributos
	
	/**
	 * Código do usuario.
	 */
	private Integer codigo;
	
	/**
	 * Nome do usuario.
	 */
	private String nome;
	
	/**
	 * Email do usuario.
	 * Também será o login dele para acessar o site.
	 */
	private String email;
	
	/**
	 * Senha do usuario para acessar o site.
	 */
	private String senha;
	
	/**
	 * Endereço na qual o usuario reside.
	 */
	private String endereco;
	
	/**
	 * Cidade na qual o usuario reside.
	 */
	private String cidade;
	
	/**
	 * Unidade Federativa na qual o usuario reside.
	 */
	private String uf;
	
	/**
	 * Inteiro para indicar o tipo de usuário.
	 */
	private Integer tipo;

	
	// Construtores
	
	/**
	 * Construtor default.
	 */
	public UsuarioBean() {
		super();
	}

	
	// Getters e Setters

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}


	/**
	 * @return the tipo
	 */
	public Integer getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
}
