package br.unisul.transportadora.bean;

/**
 * Classe que representa uma dúvida que o usuário
 * envia para a administração do site ADMTransportadoras.
 * @author Fabio Dela Bruna
 *
 */
public class DuvidaBean {

	// Atributos | OBS: os atributos a seguir (exceto codigo) são relacionados
					//	aos clientes que enviam dúvidas.
	
	/**
	 * Código da dúvida. (PK)
	 */
	private Integer codigo;
	
	/**
	 * Nome da pessoa.
	 */
	private String nome;
	
	/**
	 * Email da pessoa.
	 */
	private String email;
	
	/**
	 * Empresa da pessoa (se houver).
	 */
	private String empresa;
	
	/**
	 * DDD da cidade onde a pessoa reside.
	 */
	private String ddd;
	
	/**
	 * Telefone da pessoa.
	 */
	private String fone;
	
	/**
	 * Assunto da dúvida.
	 */
	private String assunto;
	
	/**
	 * Menssagem descrevendo a dúvida da pessoa.
	 */
	private String menssagem;
	
	
	// Construtores
	
	/**
	 * Construtor default.
	 */
	public DuvidaBean() {
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
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the ddd
	 */
	public String getDdd() {
		return ddd;
	}

	/**
	 * @param ddd the ddd to set
	 */
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	/**
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}

	/**
	 * @param fone the fone to set
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}

	/**
	 * @return the assunto
	 */
	public String getAssunto() {
		return assunto;
	}

	/**
	 * @param assunto the assunto to set
	 */
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	/**
	 * @return the menssagem
	 */
	public String getMenssagem() {
		return menssagem;
	}

	/**
	 * @param menssagem the menssagem to set
	 */
	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}

	
}
