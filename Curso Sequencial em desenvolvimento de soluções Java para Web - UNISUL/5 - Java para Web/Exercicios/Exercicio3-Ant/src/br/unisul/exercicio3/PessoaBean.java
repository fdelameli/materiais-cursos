package br.unisul.exercicio3;

/**
 * Classe Pessoa Bean.
 * @author Fabio Dela Bruna
 * @since 29/11/2008
 *
 */
public class PessoaBean {
	
	/**
	 * codigo - Código da Pessoa.
	 */
	private int codigo;
	
	/**
	 * nome - Nome da Pessoa;
	 */
	private String nome;
	
	
	/**
	 * Construtor default da classe PessoaBean.
	 */
	public PessoaBean() {
		super();
	}


	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
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
	

}
